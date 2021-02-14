package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * RGB거리
 * https://www.acmicpc.net/problem/1149
 */
public class baek1149 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		int[][] RGB = new int[N+1][3];
		
		for(int i =1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = dp[0][1] = dp[0][2] = RGB[0][0] = RGB[0][1] = RGB[0][2] = 0;
		
		for(int i=1;i<=N;i++){
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
		}

		System.out.println(Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]));

	}
}
