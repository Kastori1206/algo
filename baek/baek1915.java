package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 큰 정사각형
 * https://www.acmicpc.net/problem/1915
 */
public class baek1915 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1];

		for (int r = 1; r <= N; r++) {
			String temp = br.readLine();
			for (int c = 1; c <= M; c++) {
				map[r][c] = temp.charAt(c - 1) - '0';
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (map[r][c] == 1) {
					dp[r][c] = Math.min(Math.min(dp[r - 1][c - 1], dp[r - 1][c]), dp[r][c - 1]) + 1;
					answer = Math.max(answer, dp[r][c]);
				}
			}
		}

		System.out.println(answer * answer);
	}

}
