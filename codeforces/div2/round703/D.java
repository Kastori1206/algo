package codeforces.div2.round703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * D - Max Median
 * https://codeforces.com/contest/1486/problem/D
 */
public class D {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		int max = 0;
		
		for(int i =1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;		
			sum[i] = arr[i-1]+num;
		}
		
		for(int i = 1; i<=N;i++) {
			for(int j = i+K-1;j<=N;j++) {
				int m = (sum[j]-sum[i-1])/2;
				if(max<m) {
					max = m;
				}				
			}
		}
	
		System.out.println(max);
	}
}
