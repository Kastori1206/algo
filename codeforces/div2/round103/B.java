package codeforces.div2.round103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B.Inflation
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] p = new int[n];
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			for(int i =0;i<n;i++) {
				p[i] = Integer.parseInt(st.nextToken());
				sum += p[i];
			}
			
			sum -= p[n-1];
			
			long answer = 0;
			for(int i =n-1;i>=1;i--) {
				long max = (long)Math.floor((k*sum)/100.0);
				if(p[i] > max) {
					long temp = (long)Math.ceil((double)p[i]*100.0/k);
					answer+=(temp-sum);
					sum = temp;
				}
				sum -= p[i-1];
			}
			System.out.println(answer);
			
		}
	}
}
