package jungol;

import java.util.Scanner;

public class jungol1856 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] a = new int[N][M];
		
		int cnt = 1;
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				a[i][j+(M-1-2*j)*(i%2)] =cnt++;
			}
		}
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(a[i][j] +" ");
			}
			System.out.println();
		}
		
	}
}
