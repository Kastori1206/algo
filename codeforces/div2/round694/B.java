package codeforces.div2.round694;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws Exception{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			st = new StringTokenizer(br.readLine());
			long ans = 0;
			int[] dp = new int[n];
			
			for(int i =0;i<n;i++) {				
				arr[i] = Integer.parseInt(st.nextToken());
				int temp  = arr[i];
				ans += temp;
				while(temp %x==0) {
					temp /= x;					
					dp[i]++;
				}
				
			}
			boolean flag = false;
			while(true) {
				for(int i=0;i<n;i++) {
					if(dp[i] ==0) {
						flag = true;
						break;
					}
					ans+=arr[i];
					dp[i]--;
				}
				if(flag) {
					break;
				}
			}
			System.out.println(ans);
		}
		
	}
}
