package baek;

import java.util.Scanner;

public class baek17135 {
	static int[][] map;	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		map = new int[n+1][m];
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}		
		System.out.println(n);
		for(int i =1;i<3;i++) {
			move(i,n,m);
			System.out.println();
		}
		
//		for(int i =0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
	static void move(int turn,int n, int m) {
		
		for(int i =n-turn-1;i>=0;i--) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1) {
					attack(j,i);
				}
			}
		}
	}
	static int getDist(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
}
