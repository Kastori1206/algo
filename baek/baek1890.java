package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 점프
 * https://www.acmicpc.net/problem/1890
 */
public class baek1890 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (dp[r][c] == 0 || (r == N - 1 && c == N - 1)) {
					continue;
				}
				int next = map[r][c];
				if (r + next < N) {
					dp[r + next][c] += dp[r][c];
				}
				if (c + next < N) {
					dp[r][c + next] += dp[r][c];
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);

	}
}
