package codeforces.div2.round103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * A.K-divisible Sum
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			long n = Integer.parseInt(st.nextToken());
			long k = Integer.parseInt(st.nextToken());
			
			long nk = k;
			long answer = 1;
			if(n==1) {
				answer = k;
			}else if(n==k) {
				answer = 1;
			}else {
				answer = 1;
				while(n>nk) {
					nk += k;
				}
				answer = (long) Math.ceil((double)nk/(double)n);
				
			}
			System.out.println(answer);
		}
	}
}
