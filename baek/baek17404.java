package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB거리 2 
 * https://www.acmicpc.net/problem/17404
 */
public class baek17404 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];
		int[][] RGB = new int[N + 1][3];
		int answer = 100000000;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					dp[1][j] = RGB[1][j];
				} else {
					dp[1][j] = 100000000;
				}
			}

			for (int j = 2; j <= N; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + RGB[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + RGB[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + RGB[j][2];
			}
			for (int j = 0; j < 3; j++) {
				if (i == j) {
					continue;
				}
				answer = Math.min(answer, dp[N][j]);
			}
		}

		System.out.println(answer);

	}
}
