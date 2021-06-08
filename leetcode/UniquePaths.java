package leetcode;

/*
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 2));
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;
		for (int r = 1; r < m; r++) {
			dp[r][0] = 1;
		}
		for (int c = 1; c < n; c++) {
			dp[0][c] = 1;
		}

		for (int r = 1; r < m; r++) {
			for (int c = 1; c < n; c++) {
				dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
