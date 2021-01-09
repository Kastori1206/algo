package codeforces.div2.round695;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		for(int t =0;t<T;t++) {
			int n = Integer.parseInt(br.readLine());
			result.append("9");
			
			if(n==1) {
				result.append("\n");
				continue;
			}else {
				int display = 8;
				
				while(n-2>=0) {
					result.append(display);
					n--;
					display++;					
					display = display%10;					
				}
			}			
			result.append("\n");
		}
		System.out.println(result.toString());
	}
}
