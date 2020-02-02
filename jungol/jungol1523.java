package jungol;

import java.util.Scanner;

public class jungol1523 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(n>100 || n<0 || m<1 ||m>3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		switch(m) {
		case 1:
			for(int i =0;i<n;i++) {
				for(int j=0;j<i+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i =0;i<n;i++) {
				for(int j=0;j<n-i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}			
			break;
		case 3:
			for(int i=0;i<n;i++) {
				for(int j =n-1;j>i;j--) {
					System.out.print(" ");
				}
				for(int k =0;k<2*i+1;k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		
		
	}
}
