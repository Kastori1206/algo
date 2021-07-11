package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 동전 2
 * https://www.acmicpc.net/problem/2294
 */
public class baek2294 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] dp = new int[K+1];
		
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		for(int i =1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			for(int j = arr[i];j<=K;j++) {
				dp[j] = Math.min(dp[j] , dp[j - arr[i]]+1);
			}
		}
		
		System.out.println(dp[K] == 10001 ? -1 : dp[K]);
	}
}
