package codeforecs.div2.round694;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t= 0; t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] k = new int[n];
			int[] c = new int[m+1];
			int[] want = new int[m+1];
			
			st= new StringTokenizer(br.readLine());
			
			for(int i =0;i<n;i++) {
				k[i] = Integer.parseInt(st.nextToken());
				want[k[i]] ++;
			}
			st= new StringTokenizer(br.readLine());
			
			for(int i =1;i<=m;i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}
						
			long ans =0;
			int present =1;
			for(int i =m;i>=0;i--) {
				while(want[i] >0) {
					if(i>=present) {
						ans += c[present];
						present++;
					}else {
						ans +=c[i];
					}
					want[i]--;
				}
			}
			System.out.println(ans);
		}
	}
}
