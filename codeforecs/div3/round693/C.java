package codeforecs.div3.round693;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ;t <T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n+1];
			int[] dp = new int[n+1];
			
			st = new StringTokenizer(br.readLine());			
			for(int i=1;i<=n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());				
			}
			
			int max =-1;
			for(int i =n;i>=1;i--) {
				int now = i;
				int sum = 0;
				while(now < n+1) {
					if(dp[now] != 0) {
						sum+= dp[now];
						break;
					}
					sum += arr[now];
					now += arr[now];
				}
				dp[i] = sum;
				max = Math.max(max, sum);
			}
			
			System.out.println(max);
		}
	}
}
