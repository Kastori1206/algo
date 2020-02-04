package baek;

import java.util.Scanner;

public class baek1012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case =0;test_case <T;test_case++) {
			int n = sc.nextInt();//i크기
			int m = sc.nextInt();//j크기
			int[][] map = new int[n][m];//맵
			int[][] v = new int[n][m];//방문체크
			int size = sc.nextInt();//좌표 수
			
			int[] a = new int[2]; //입력받는 i,j좌표 저장배열
			
			for(int i =0;i<size;i++) {				
				for(int j =0;j<2;j++) {
					a[j] = sc.nextInt();
				}
				map[a[0]][a[1]] = 1;
			}
			
			
			
		}		
	}
	static void dfs() {
		
	}
}
