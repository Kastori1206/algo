package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 정수 삼각형
 * https://www.acmicpc.net/problem/1932
 */
public class baek1932 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[500][500];
		int[][] arr = new int[N][N];
		for(int r =0; r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0;c<r+1;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		for(int r = 0;r<N-1;r++) {
			for(int c=0;c<r+1;c++) {
				dp[r+1][c] = Math.max(dp[r+1][c],dp[r][c] + arr[r+1][c] );
				dp[r+1][c+1] = Math.max(dp[r+1][c+1], dp[r][c] + arr[r+1][c+1]);
			}
		}
		
		int answer = 0;
		for(int i = 0 ; i<N;i++) {
			answer = Math.max(answer, dp[N-1][i]);
		}
		System.out.println(answer);
	}
}
