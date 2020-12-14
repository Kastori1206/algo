package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek15989 {
	static int N,T;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new int[10001][4];
		
		dp[1][1] = 1;
		dp[1][2] = dp[1][3] = 0;
		
		dp[2][1] = dp[2][2] = 1;
		dp[2][3] = 0;
		
		dp[3][1] = dp[3][2] = dp[3][3] = 1;
		
		for(int i =4 ;i<10001;i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}
		StringBuffer sb = new StringBuffer();
		for(int t = 0 ;t< T ; t++) {
			N = Integer.parseInt(br.readLine());
			int sum = dp[N][1] + dp[N][2] + dp[N][3];
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
	
}
