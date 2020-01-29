package jungol;

import java.util.Scanner;

public class jungol1459 {
	static boolean check[];
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		arr = new int[N+1];
		check = new boolean[N+1];
		
		for(int i =1;i<=N;i++) {
			arr[i] = sc.nextInt();
		}
		
		
	}
	static void go(int N,int k,int max) {
		if(N == k) {
			
			System.out.println(max);
			return;
		}
	}

}
