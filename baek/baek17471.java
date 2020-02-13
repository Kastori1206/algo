package baek;

import java.util.Scanner;

public class baek17471 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] w = new int[n+1];
		int[][] map = new int[n+1][n+1];
		
		for(int i =1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		for(int i =1;i<=n;i++) {
			int end = sc.nextInt();
			for(int j=1;j<=end;j++ ) {
				map[i][sc.nextInt()] =1;
			}
		}
		
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=n;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
		
	}
}
