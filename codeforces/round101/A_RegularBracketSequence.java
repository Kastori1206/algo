package codeforces.round101;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A_RegularBracketSequence {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			int cnt = 0;
			int temp = 0;
			if(ch[0] ==')' || ch[ch.length-1] =='(') {
				System.out.println("NO");
				continue;
			}
			for(int i =0;i<ch.length;i++) {
				if(ch[i] == '(') {
					cnt++;
				}else if(ch[i] == ')') {
					cnt--;
				}else {
					temp++;
				}
			}
			
			cnt = Math.abs(cnt);
			
			if(cnt==0 && temp%2==0) {
				cnt = 0;
			}else {
				if(cnt == temp) {
					cnt = 0;
				}else {
					cnt = -1;
				}
			}
			System.out.println(cnt ==0 ? "YES" : "NO");
		}//T 끝
		
	}
}
