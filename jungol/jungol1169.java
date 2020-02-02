package jungol;

import java.util.Scanner;

public class jungol1169 {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		arr= new int[N+1];
		arr[0] = 1;

		switch(M) {
		case 1:
			dfs1(1,N);
			break;
		case 2:
			dfs2(1,N);
			break;
		case 3:
			boolean[] b = new boolean[6+1];
			dfs3(1,N,b);
		}

	}
	static void dfs1(int idx ,int N) {
		if(N == 0) {
			print();
			return;
		}
		for(int i =1;i<=6;i++) {
			arr[idx] = i;
			dfs1(idx+1,N-1);
		}   
	}
	static void dfs2(int idx ,int N) {
		if(N == 0) {
			print();
			return;
		}
		for(int i =arr[idx-1];i<=6;i++) {
			arr[idx] = i;
			dfs2(idx+1,N-1);           
		}   
	}
	static void dfs3(int idx ,int N,boolean[] b) {
		if(N == 0) {
			print();
			return;
		}
		for(int i =1;i<=6;i++) {
			if(!b[i]) {            
				b[i] = true;
				arr[idx] = i;
				dfs3(idx+1,N-1,b);
				b[i] = false;
			}
		}   
	}
	static void print() {
		for(int i =1;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");          
		}
		System.out.println();
	}
}