package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항 계수2
 * https://www.acmicpc.net/problem/11051
 */
public class baek11051 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int mod = 10007;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][K+1];
		
		for(int i=0; i<=N ;i++) {
			dp[i][0] = 1;
		}
		
		for(int i =0;i<=K;i++) {
			dp[i][i] = 1;
		}
		
		for(int i =1 ; i<=N;i++) {
			for(int j=1;j<=K ;j++) {
				dp[i][j] = (dp[i-1][j] + dp[i-1][j-1])%mod;
			}
		}
		System.out.println(dp[N][K]);
	}
}
