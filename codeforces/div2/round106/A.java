package codeforces.div2.round106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A. Domino on Windowsill
 * https://codeforces.com/contest/1499/problem/A
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			int k1 = Integer.parseInt(st.nextToken());
			int k2 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int min = Math.min(k1, k2);
			int max = Math.max(k1, k2);
			
			int white = min;
			int black = n-max;
			max -= min;
			
			if(max!=0) {
				white += max/2;
				black += max/2;
			}		
						
	
			if(black>= b && white>=w) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
			
		
	}
}
