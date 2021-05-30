package programmers;

public class 멀리뛰기 {
	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(solution(3));
	}
	public static long solution(int n) {
		long[] dp = new long[2001];
		int mod = 1234567;
		dp[1] = 1;
		dp[2] = 2;
		for(int i =3;i<=n;i++) {
			dp[i] = (dp[i-1] +dp[i-2])%mod;
		}
		return dp[n];
	}
}
