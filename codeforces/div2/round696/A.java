package codeforces.div2.round696;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int  t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			char[] A= br.readLine().toCharArray(); 
			String answer = "1";
			int temp = (A[0]-'0') +1; 
			
			for(int i=1;i<N;i++) {
				if(temp != (A[i]-'0')+1) {
					answer+="1";
					temp = (A[i]-'0')+1;
				}else {
					answer += "0";	
					temp = (A[i]-'0')+0;

				}
			}
			
			System.out.println(answer);
		}
		
	}
}
