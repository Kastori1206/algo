package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 동전 1
 * https://www.acmicpc.net/problem/2293
 */
public class baek2293 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] dp = new int[K+1];
		
		dp[0] = 1;
		for(int i =1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j = arr[i];j<=K;j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		System.out.println(dp[K]);
		
	}
}
