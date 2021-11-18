package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주지수 
 * https://www.acmicpc.net/problem/15724
 */
public class baek15724 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r - 1][c - 1] + map[r][c];
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			answer.append(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]).append("\n");
		}

		System.out.println(answer.toString());
	}
}
