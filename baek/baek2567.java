package baek;

import java.util.Scanner;

public class baek2567 {
	//상하좌우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][]map = new int[100+2][100+2];
		for(int i =0;i<N;i++) {
			int x = sc.nextInt()+1;
			int y = sc.nextInt()+1;
			for(int j=y;j<y+10;j++) {
				for(int k=x;k<x+10;k++) {
					if(map[j][k]==0) {
						map[j][k] = 1;
					}
				}
			}						
		}
		int cnt =0;
		for(int i =1;i<=100;i++) {
			for(int j=1;j<=100;j++) {
				if(map[i][j]==1) {					
					for(int k=0;k<4;k++) {
						int nx = j+dx[k];
						int ny = i+dy[k];
						
						if(map[ny][nx]==0) {
							cnt++;
						}					
					}
				}
			}
		}
		System.out.println(cnt);			
	}
}
