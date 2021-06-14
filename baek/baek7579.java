package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 앱
 * https://www.acmicpc.net/problem/7579
 */
public class baek7579 {
	static final int MAX = 10001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;
		int[] costs = new int[N];
		int[] memorys = new int[N];
		int[][] dp = new int[N][MAX];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			memorys[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			int cost = costs[i];
			int memory = memorys[i];

			for (int j = 0; j < MAX; j++) {
				if (i == 0) {
					if (j >= cost) {
						dp[i][j] = memory;
					}
				} else {
					if (j >= cost) {
						dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
				if (dp[i][j] >= M) {
					answer = Math.min(answer, j);
				}
			}
		}

		System.out.println(answer);
	}
}
