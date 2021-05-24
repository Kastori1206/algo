package programmers;

/*
 * 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길 {
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {
				{2,2}
		};
		System.out.println(solution(m, n, puddles));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		
		int[][] dp = new int[n][m];
		for(int i =0;i<puddles.length;i++) {
			dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
		}
		
		dp[0][0] = 1;
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(dp[i][j]==-1) {
					dp[i][j]=0;
					continue;
				}
				if(i!=0) {
					dp[i][j] += dp[i-1][j] % mod;
				}
				if(j!=0) {
					dp[i][j] += dp[i][j-1]%mod;
				}
			}
		}
		return dp[n-1][m-1]%mod;
	}
}
