package codeforces.div2.round698;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B. Nezzar and Lucky Number
 */
public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<q;i++) {
				String num = st.nextToken();						
				if(check(num, d)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
			
		}
	}

	private static boolean check(String num, int d) {
		int n = Integer.parseInt(num);
		while(true) {
			if(n<0) {
				return false;
			}
			String temp = n+"";
			for(int i =0;i<temp.length();i++) {
				if(temp.charAt(i)-'0' == d) {
					return true;
				}
			}
			n-=d;
		}
	}
}
