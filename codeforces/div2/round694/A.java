package codeforces.div2.round694;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0 ; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			long max = 0;
			long min = 0;
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				min+= arr[i];
				max += (long)Math.ceil((double)arr[i]/(double)x);
			}
			
			System.out.println( (long)Math.ceil((double)min/(double)x) + " " + max);
			
		}
	}
}
