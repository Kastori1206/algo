package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내려가기 
 * https://www.acmicpc.net/problem/2096
 */
public class baek2096 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[2][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			if (i == 0) {
				dp[0][0] = dp[1][0] = n0;
				dp[0][1] = dp[1][1] = n1;
				dp[0][2] = dp[1][2] = n2;
			} else {
				int beforeMaxN0 = dp[0][0], beforeMaxN2 = dp[0][2];

				dp[0][0] = Math.max(dp[0][0], dp[0][1]) + n0;
				dp[0][2] = Math.max(dp[0][1], dp[0][2]) + n2;
				dp[0][1] = Math.max(Math.max(beforeMaxN0, dp[0][1]), beforeMaxN2) + n1;

				int beforeMinN0 = dp[1][0], beforeMinN2 = dp[1][2];
				dp[1][0] = Math.min(dp[1][0], dp[1][1]) + n0;
				dp[1][2] = Math.min(dp[1][1], dp[1][2]) + n2;
				dp[1][1] = Math.min(Math.min(beforeMinN0, dp[1][1]), beforeMinN2) + n1;
			}
		}

		int max = Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]);
		int min = Math.min(Math.min(dp[1][0], dp[1][1]), dp[1][2]);

		System.out.println(max + " " + min);
	}
}
