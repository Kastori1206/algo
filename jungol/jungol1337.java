package jungol;

import java.util.Scanner;

public class jungol1337 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n<0 || n>100) {
			return;
		}
		
		int[][] a = new int[n][n];
		int i=0; int j=0; int k = n;
		int num =0;
		int dir = 0;
		int cnt = 0;
		while(k!=0) {
			a[i][j] = num++;
			num %= 10;
			cnt++;		
			switch (dir) {
			case 0://우하로이동
				if(cnt == k) {
					dir =1;
					k--;
					cnt = 0;
					j--;
				}else {
					i++;
					j++;
				}
				break;
			case 1://좌로이동
				if(cnt==k) {
					dir =2;
					k--;
					cnt = 0;
					i--;
				}else {
					j--;
				}
				break;
			case 2://상으로이동
				if(cnt == k) {
					dir = 0;
					k--;
					cnt = 0;
					i++;
					j++;
				}else {
					i--;
				}
				break;
			}
		}
		print(a);
		
	}
	static void print(int[][] a) {
		for(int i =0;i<a.length;i++) {
			for(int j =0;j<i+1;j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
