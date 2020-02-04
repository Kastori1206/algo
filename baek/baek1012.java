package baek;

import java.util.Arrays;
import java.util.Scanner;

public class baek1012 {
	//상, 하, 좌, 우
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case =0;test_case <T;test_case++) {
			int m = sc.nextInt();//j크기
			int n = sc.nextInt();//i크기
			int[][] map = new int[n][m];//맵
			int[][] v = new int[n][m];//방문체크
			int size = sc.nextInt();//좌표 수
			int result = 0;
			int[] a = new int[2]; //입력받는 j,i좌표 저장배열
			
			for(int i =0;i<size;i++) {				
				for(int j =0;j<2;j++) {
					a[j] = sc.nextInt(); //가로 세로
				}
				map[a[1]][a[0]] = 1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] ==0) {
						continue;
					}
					if(v[i][j] !=0) {
						continue;
					}
					result++;
					dfs(map,v,j,i,n,m);
				}
			}
			System.out.println(result);
			
		}		
	}
	static void dfs(int[][] map, int[][] v, int x, int y, int n, int m) {
		v[y][x] = 1;
		for(int i =0 ;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(isBound(nx, ny, n,m)) {
				continue;
			}
			if(map[ny][nx] ==0 ) {
				continue;
			}
			if(v[ny][nx] !=0) {
				continue;
			}
			dfs(map,v,nx,ny,n,m);
		}
		
	}
	//x,y 범위 체크
	static boolean isBound(int x, int y, int N,int M) {
		if(x>=M||x<0||y>=N||y<0) {
			return true;
		}
		return false;
	}
}
