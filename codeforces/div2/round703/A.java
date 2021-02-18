package codeforces.div2.round703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A. Shifting Stacks
 * https://codeforces.com/contest/1486/problem/A
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t =0 ; t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N];
			st = new StringTokenizer(br.readLine());

			boolean flag = true;
			for(int i =0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if(i>0) {
					arr[i] += arr[i-1]-(i-1);
					arr[i-1] = i-1;
					if(arr[i]<= arr[i-1]) {
						flag= false;
						break;
					}
				}
			}
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}			
			
			
		}
	}
}
