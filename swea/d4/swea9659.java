package swea.d4;

import java.util.Scanner;

/*
 * D4 swea 9659 다항식계산
 */
public class swea9659 {
	static long MOD = 998244353L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			long[] dp = new long[N + 1];

			int[][] arr = new int[N + 1][3];
			for (int i = 2; i <= N; i++) {
				for (int j = 0; j < 3; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int M = sc.nextInt();
			StringBuilder result = new StringBuilder();
			result.append("#" + t);
			for (int i = 0; i < M; i++) {
				long x = sc.nextLong();
				dp[0] = 1;
				dp[1] = x;
				for (int j = 2; j <= N; j++) {
					int a = arr[j][1];	//ai
					int b = arr[j][2];	//bi
					switch (arr[j][0]) {//ti
					case 1:
						dp[j] = (dp[a] + dp[b]) % MOD;
						break;
					case 2:
						dp[j] = (a * dp[b]) % MOD;
						break;
					case 3:
						dp[j] = (dp[a] * dp[b]) % MOD;
						break;
					}
				}
				result.append(" " + dp[N]);
			}
			System.out.println(result);
		}
	}

}
