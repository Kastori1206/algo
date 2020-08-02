package swea;

import java.util.Scanner;

/*
 * [모의 SW 역량테스트] 디저트 카페
 */
public class swea2105 {
	static boolean[] check;
	static int[][] map;
	static boolean[][] v;
	static int n,startX, startY;
	static int result;
	static int[] dx = {1, -1, -1, 1};
	static int[] dy = {1, 1, -1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t<= T;t++) {
			n = sc.nextInt();
			
			map = new int[n][n];
			result = -1;
			check = new boolean[101];			
			
			for(int i =0;i<n;i++) {
				for(int j =0;j<n;j++) {
					map[i][j] = sc.nextInt();
				}
			}			
			
			for(int i =0;i<n;i++) {
				for(int j=1;j<n;j++) {
					startX = j;
					startY = i;
					check[map[i][j]] = true;
					dfs(j,i,0,1);
					check[map[i][j]] = false;
				}
			}
			
			System.out.printf("#%d %d\n",t,result);
		}//test_case		
	}//main
	static void dfs(int x, int y,int dir, int cnt) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(dir ==3 && nx ==startX && ny == startY) {
			result = Math.max(result,cnt);
			return;
		}
		if(0<=ny && 0<=nx && ny<n && nx<n &&!check[map[ny][nx]]) {
			check[map[ny][nx]] = true;
			dfs(nx,ny,dir,cnt+1);
			if(dir<3) {
				dfs(nx,ny,dir+1,cnt+1);
			}
			check[map[ny][nx]] = false;
		}
	}
}
