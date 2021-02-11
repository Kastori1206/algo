package codeforces.div3.round697;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			long N = Long.parseLong(br.readLine());
			boolean flag = false;
			while (N > 1) {
				if (N % 2 == 1) {
					flag = true;
					break;
				}
				N /=2;
			}
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
