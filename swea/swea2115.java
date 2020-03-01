package swea;

import java.util.Scanner;

/*
 * 2115. [모의 SW 역량테스트] 벌꿀채취
 */
public class swea2115 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int c = sc.nextInt();
			
			int[][] map = new int[n][n];
			for(int i =0;i<n;i++) {
				for(int j =0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			boolean[][] v = new boolean[n][n];
			
			for(int i =0;i<n;i++) {
				for(int j=0;j<n-m;j++) {
					if(v[i][j]) {
						continue;
					}
					go(map,v,i,j,c);
				}
			}
		}
	}
	static void go(int[][] map, boolean[][] v, int y, int x,int c) {
		
	}
}
