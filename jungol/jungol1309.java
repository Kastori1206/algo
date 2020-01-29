package jungol;

import java.util.Scanner;

public class jungol1309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		fact(N,1);

	}
	static void fact(int N,long result) {
		if(N ==1) {
			System.out.println(N+"! = 1");
			System.out.println(result);
			return;
		}
		System.out.println(N+"! = "+N+" * "+(N-1)+"!");
		result *= N;
		fact(N-1,result);
	}

}
