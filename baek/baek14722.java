package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 우유 도시
 * https://www.acmicpc.net/problem/14722
 */
public class baek14722 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		if (map[0][0] == 0) {
			dp[0][0][0] = 1;
		}

		for (int r = 1; r < N; r++) {
			int milk = map[r][0];

			if (milk == 0) {
				dp[r][0][0] = dp[r - 1][0][2] + 1;
			} else {
				dp[r][0][0] = dp[r - 1][0][0];
			}
			if (milk == 1 && dp[r][0][2] < dp[r][0][0]) {
				dp[r][0][1] = dp[r - 1][0][0] + 1;
			} else {
				dp[r][0][1] = dp[r - 1][0][1];
			}
			if (milk == 2 && dp[r][0][0] < dp[r][0][1]) {
				dp[r][0][2] = dp[r - 1][0][1] + 1;
			} else {
				dp[r][0][2] = dp[r - 1][0][2];
			}

		}

		for (int c = 1; c < N; c++) {
			int milk = map[0][c];

			if (milk == 0) {
				dp[0][c][0] = dp[0][c - 1][2] + 1;
			} else {
				dp[0][c][0] = dp[0][c - 1][0];
			}
			if (milk == 1 && dp[0][c][2] < dp[0][c][0]) {
				dp[0][c][1] = dp[0][c - 1][0] + 1;
			} else {
				dp[0][c][1] = dp[0][c - 1][1];
			}
			if (milk == 2 && dp[0][c][0] < dp[0][c][1]) {
				dp[0][c][2] = dp[0][c - 1][1] + 1;
			} else {
				dp[0][c][2] = dp[0][c - 1][2];
			}

		}

		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {
				int milk = map[r][c];

				if (milk == 0) {
					dp[r][c][0] = Math.max(dp[r][c - 1][2] + 1, dp[r - 1][c][2] + 1);
				} else {
					dp[r][c][0] = Math.max(dp[r - 1][c][0], dp[r][c - 1][0]);
				}
				if (milk == 1 && dp[r][c][2] < dp[r][c][0]) {
					dp[r][c][1] = Math.max(dp[r - 1][c][0] + 1, dp[r][c - 1][0] + 1);
				} else {
					dp[r][c][1] = Math.max(dp[r - 1][c][1], dp[r][c - 1][1]);
				}
				if (milk == 2 && dp[r][c][0] < dp[r][c][1]) {
					dp[r][c][2] = Math.max(dp[r - 1][c][1] + 1, dp[r][c - 1][1] + 1);
				} else {
					dp[r][c][2] = Math.max(dp[r - 1][c][2], dp[r][c - 1][2]);
				}
			}

		}
		System.out.println(Math.max(dp[N - 1][N - 1][0], Math.max(dp[N - 1][N - 1][1], dp[N - 1][N - 1][2])));

	}
}
