package codeforces.div2.round695;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			int[] dp = new int[n];
			
			st = new StringTokenizer(br.readLine());
			
			int result = 0;
			for(int i =0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());			
			}
			
			for(int i =1;i<n-1;i++) {
				if(arr[i-1]<arr[i] && arr[i] >arr[i+1]) {
					result++;
					dp[i] = 1;
				}else if(arr[i-1]>arr[i] && arr[i] <arr[i+1]) {
					result++;
					dp[i] = -1;
				}	
			}
			
			int cnt = 0;
			for(int i =1;i<n-1;i++) {				
								
			}
			
			if(cnt ==0) {
				cnt =1;
			}
			
			System.out.println(result-cnt <0 ? 0 : result-cnt);
		}
	}
	
}
