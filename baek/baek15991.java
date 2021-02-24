package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek15991 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t= 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 2;  
			
			for(int i =4;i<=N;i++) {
				dp[i] = dp[i/2]+1+dp[i-3]+dp[i-2]+dp[i-1];
			}
			System.out.println(dp[N]);
			
		}
	}
}
