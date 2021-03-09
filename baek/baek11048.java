package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 이동하기
 * https://www.acmicpc.net/problem/11048
 */
public class baek11048 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][M+1];
		for(int r = 1; r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c= 1;c<=M;c++) {
				int num = Integer.parseInt(st.nextToken());
				dp[r][c] =Math.max(Math.max(dp[r-1][c-1], dp[r-1][c]),dp[r][c-1])+num;
			}
		}
		System.out.println(dp[N][M]);
	}
}
