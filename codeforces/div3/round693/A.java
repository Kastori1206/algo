package codeforces.div3.round693;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0 ;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int cnt = 1;			
		
			while(w%2==0 || h%2==0) {
				if(w%2 ==0) {
					w /= 2;
					cnt *=2;
				}else if(h%2==0) {
					h/=2;
					cnt *=2;
				}else {
					break;
				}
			}
			
			System.out.println(cnt >=n ? "YES" : "NO");
		}
	}
}
