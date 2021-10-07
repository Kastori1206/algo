package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 01타일
 * https://www.acmicpc.net/problem/1904
 */
public class baek1904 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		if(N==1) {
			System.out.println(1);
			return;
		}
		dp[1] = 1;
		dp[2] = 2;
		//1 1
		//2 00 11
		//3 001 111 100
		//4 0011 1100 1001 1111 1100		
		for(int i  = 3 ;i<=N;i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
	
		System.out.println(dp[N]);
	}
}
