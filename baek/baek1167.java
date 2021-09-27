package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 지름
 * https://www.acmicpc.net/problem/1167
 */
public class baek1167 {
	static class Edge{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		
	}
	static List<Edge> [] adj;
	static boolean[] visited;
	static int N, maxV;
	static long answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i =1; i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			while(st.hasMoreElements()) {
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) {
					break;
				}
				int w = Integer.parseInt(st.nextToken());
				adj[a].add(new Edge(b, w));
			}
		}
		
		answer = 0;
		dfs(1,0);
		visited = new boolean[N+1];
		dfs(maxV, 0);
		System.out.println(answer);
		
	}
	public static void dfs(int v, long sum) {	
		if(answer < sum) {
			answer = sum;
			maxV = v;
		}		
		visited[v] = true;
		
		for(Edge next :adj[v]) {
			if(visited[next.v]) {
				continue;
			}
			dfs(next.v, sum + next.w);
		}
	}
}
