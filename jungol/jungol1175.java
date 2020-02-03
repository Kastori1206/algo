package jungol;

import java.util.Scanner;

public class jungol1175 {
	static int[] arr ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N+1];
		dfs(1,N,0,M);
		
	}
	static void dfs(int idx ,int N, int sum,int target) {
		if(N == 0) {
			if(sum == target) {
				print();				
			}
			return;
		}
		for(int i =1;i<=6;i++) {
			arr[idx] = i;
			dfs(idx+1,N-1,sum+arr[idx],target);
		}	
	}
	
	static void print() {
		for(int i =1;i<arr.length;i++) {
			System.out.print(arr[i]+ " ");			 
		}
		System.out.println();
	}
}
