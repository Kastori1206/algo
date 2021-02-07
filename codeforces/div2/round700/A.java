package codeforces.div2.round700;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A - Yet Another String Game
 */
public class A {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0;t<T;t++) {
			char[] a = br.readLine().toCharArray();
			
			for(int i =0;i<a.length;i++) {
				if(i%2==0) {
					if(a[i] == 'a') {
						a[i] = 'b';
					}else {
						a[i] = 'a';
					}
					
				}
				//b
				else {
					if(a[i] == 'z') {
						a[i] = 'y';
					}else {
						a[i] = 'z';
					}
				}
			}			
			
			System.out.println(String.valueOf(a));
		}
	}
}
