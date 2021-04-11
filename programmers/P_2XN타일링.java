package programmers;

/*
 * 2XN타일링
 * https://programmers.co.kr/learn/courses/30/lessons/12900
 */
public class P_2XN타일링 {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	static public int solution(int n) {
		int mod = 1_000_000_007;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
		}
		return dp[n] % mod;
	}
}
