package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색상환 
 * https://www.acmicpc.net/problem/2482
 */
public class baek2482 {
	static int[][] dp;
	static int N, K;
	static final int MOD = 1000000003;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());	
		
		dp = new int[N+1][N+1];
		
		for(int i =1;i<=N;i++) {
			dp[i][1] = i;
			dp[i][0] = 1;
		}
		
		for(int i = 3;i<=N;i++) {
			for(int j = 2; j<=(i+1)/2;j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-2][j-1])%MOD;
			}
		}
		
		System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % MOD);
	}

}
