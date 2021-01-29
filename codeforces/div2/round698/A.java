package codeforces.div2.round698;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A. Nezzar and Colorful Balls 
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			int[] count = new int[100+1];
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i] = num;
				count[num]++;
			}
			
			int answer = Integer.MIN_VALUE;
			for(int i =1;i<=100;i++) {
				answer = Math.max(answer, count[i]);
			}
			
			System.out.println(answer);
		}
	}
}
