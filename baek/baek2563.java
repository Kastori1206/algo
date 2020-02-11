package baek;

import java.util.Scanner;

public class baek2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		for(int i =0;i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int j=y;j<y+10;j++) {
				for(int k = x; k<x+10;k++) {
					if(map[j][k] !=0) {
						continue;
					}
					map[j][k] = 1;
				}
			}
		}
		int cnt =0;
		for(int i =0;i<100;i++) {
			for(int j =0;j<100;j++) {
				if(map[i][j] == 1){
					cnt++;
				}				
			}
		}
		System.out.println(cnt);
		
	}
}
