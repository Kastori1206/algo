package baek;

import java.util.Scanner;

/*
 * 1699. 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */
public class baek1699 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] d = new int[n+1];		
		
		for(int i=1;i<=n;i++) d[i] = i;
		for(int i=2;i<=n;i++) {
			for(int j=2;j*j<=i;j++) {
				d[i] = Math.min(d[i], d[i-j*j]+1);				
			}			
		}
		System.out.println(d[n]);	
	}	
}
