package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 우주탐사선
 * https://www.acmicpc.net/problem/17182
 * 플로이드와샬 + 순열
 */
public class baek17182 {
	static int[][] map;
	static int N,K, ans;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		for(int r = 0 ;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ;c< N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k =0;k<N; k++) {
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(j==k || i==j) {
						continue;
					}
					if(map[i][k] + map[k][j] < map[i][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		for(int r =0 ; r<N;r++) {
			for(int c =0; c<N;c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
		visited = new boolean[N];
		int[] result = new int[N];
		visited[K] = true;
		result[0] = K;
		dfs(1,result,0);
		System.out.println(ans);
	}	
	
	private static void dfs(int index,int[] result,int sum) {
		if(index == N) {
			ans = Math.min(ans, sum);
			return;
		}
		if(ans < sum) {
			return;
		}
		for(int i =0;i<N;i++) {
			if(visited[i]) {
				continue;
			}
			result[index] = i;
			visited[i] = true;
			dfs(index+1,result,sum+map[result[index-1]][i]);
			visited[i] = false;
		}
	}
}
