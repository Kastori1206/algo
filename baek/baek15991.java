package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1, 2, 3 더하기 6
 * https://www.acmicpc.net/problem/15991
 */
public class baek15991 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();

		long[] dp = new long[100_001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;
		dp[4] = 3;
		dp[5] = 3;
		dp[6] = 6;
		
		//d[n] = d[n-2] + d[n-4] + d[n-6];
		for (int i = 7; i <= 100000; i++) {
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009;
		}
		
		for (int t = 0; t < T; t++) {
			answer.append(dp[Integer.parseInt(br.readLine())]).append("\n");

		}
		System.out.println(answer.toString());
	}
}
