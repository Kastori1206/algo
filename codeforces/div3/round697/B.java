package codeforces.div3.round697;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			if(N/2020 >= N%2020) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	
}
