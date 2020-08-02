package swea.d3;

import java.util.Scanner;

/*
 * 2814.최적경로
 * 
 */
public class swea2814 {
	static int N;
	static int M;
	static int[][] adj;
	//어떤 방문체크상태로, 어떤 정점에 도달했는지.
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T;t++) {
			N = sc.nextInt();	//정점의 갯수 1<= N M <= 10
			M = sc.nextInt();	//간선의 갯수 <=20
			adj = new int[N+1][N+1];
			memo = new int[1<<(N+1)][N+1];
//			visited = new boolean[N+1];
			for(int i =0;i<M;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a][b] =1;
				adj[b][a] = 1;
			}
			for(int i = 1;i<=N;i++) {
//				visited[i] = true;
//				dfs(i,1);
//				visited[i] = false;
				ans = Math.max(ans, dfs(i,1<<i));
			}
			System.out.printf("#%d %d",t,ans);
		}
	}
//	static boolean[] visited;
	static int ans = 0;
//	static void dfs(int v, int cnt) {
//		// 더이상 방문할 노드가 없음 : 기저파트
//		// cnt가 가장 큰값
//		ans = Math.max(ans, cnt);
//		//모든 노드 중에서 나와 간선이 존재하고, 아직 방문하지 않은 노드라면 방문
//		
//		for(int i =1;i<=N;i++) {
//			if(adj[v][i] == 1 && !visited[i]) {
//				visited[i] =true;
//				dfs(i,cnt+1);
//				visited[i] =false;
//			}
//		}
//	}
	static int dfs(int v, int visited) {
		if(memo[visited][v] != 0) {
			return memo[visited][v];
		}
		int ret =1;
		for(int i =1;i<=N;i++) {
			if(adj[v][i] == 1 && (visited & (1<<i)) !=0) {
				ret = Math.max(ret, dfs(i,visited | (1<<i)) +1);
			}
		}
		memo[visited][v] = ret;
		return ret;//현재 정점으로부터 남은 최장경로;
	}	
}
