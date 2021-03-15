package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 파일 합치기
 * https://www.acmicpc.net/problem/11066
 */
public class baek11066 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			int K = Integer.parseInt(br.readLine());
		
			int[] sum = new int[K+1];
			int[][] dp = new int[K+1][K+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i =1;i<=K;i++) {
				int num = Integer.parseInt(st.nextToken());
				sum[i] +=sum[i-1]+num;
			}
			
			for(int i =1;i<K;i++) {
				for(int from=1;from+i<=K;from++) {
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int j=from;j<to;j++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][j]+dp[j+1][to] + sum[to] - sum[from-1]);
					}
				}
			}
			
			System.out.println(dp[1][K]);
		}
	}
}
