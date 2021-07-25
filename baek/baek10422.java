package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 괄호
 * https://www.acmicpc.net/problem/10422
 */
public class baek10422 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int MOD = 1000000007;
		StringBuilder answer = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for(int i =3;i<=5000;i++) {
			for(int j=2;j<=i;j++) {
				dp[i] += dp[j-2]* dp[i-j];
				dp[i] %=MOD;
			}
		}
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			answer.append(String.valueOf(dp[num])).append("\n");
		}
		System.out.println(answer.toString());
	}
}
