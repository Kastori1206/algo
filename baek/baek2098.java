package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 외판원 순회
 * https://www.acmicpc.net/problem/2098
 */
public class baek2098 {
	static final int INF = 16*1_000_000;
	static int N;
	static int[][] W, dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W  = new int[N][N];
		dp = new int[N][(1<<N)-1];
		for(int i =0;i<N;i++) {
			Arrays.fill(dp[i], INF);
		}
		
		for(int r =0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0;c<N;c++) {
				W[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(tsp(0,1));
		
	}
	private static int tsp(int node, int visited) {
		if(visited==(1<<N) -1) {
			if(W[node][0] == 0) {
				return INF;
			}
			return W[node][0];
		}
		
		if(dp[node][visited] !=INF) {
			return dp[node][visited];
		}
		
		for(int i =0;i<N;i++) {
			if(W[node][i] == 0 || (visited &(1<<i)) !=0) {
				continue;
			}
			
			int next = visited | (1<<i);
			dp[node][visited] = Math.min(dp[node][visited], tsp(i, next)+ W[node][i]);

		}
		return dp[node][visited];
	}
}
