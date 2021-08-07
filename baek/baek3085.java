package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 사탕 게임
 * https://www.acmicpc.net/problem/3085
 */
public class baek3085 {
	static char[][] map;
	static int N, answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		answer = 0;
		for(int r=0;r<N;r++) {
			String temp = br.readLine();
			for(int c =0;c<N;c++) {
				map[r][c] = temp.charAt(c);
			}
		}
		for(int r = 0;r<N;r++) {
			for(int c = 0;c<N;c++) {
				select(r, c, map[r][c]);
			}
		}
		System.out.println(answer);
	}

	public static void select(int r, int c, char color) {
		if(c+1<N && color != map[r][c+1]) {
			swap(r, c, r, c+1);		
			check();
			swap(r, c, r, c+1);			
		}
		
		if(r+1<N && color != map[r+1][c]) {			
			swap(r,c,r+1,c);
			check();
			swap(r,c,r+1,c);
		}
	}
	
	public static void swap(int r, int c, int nr, int nc) {
		char temp = map[nr][nc];
		map[nr][nc] = map[r][c];
		map[r][c] = temp;
	}
	
	public static void check() {
		boolean[][] visited = new boolean[N][N];		
		for(int r =0;r<N;r++) {
			for(int c =0;c<N;c++) {				
				if(visited[r][c]) {
					continue;
				}
				eatCol(map[r][c], r, c);
				eatRow(map[r][c], r, c);				
			}
		}
	}
	
	public static void eatCol(char color,int r, int c) {
		int cnt = 1;
		int move =1;
		while(c+move <N) {
			if(color == map[r][c+move]) {
				cnt++;
				move++;
			}else {
				break;
			}
		}
		answer = Math.max(cnt, answer);
	}
	
	public static void eatRow(char color,int r, int c) {
		int cnt = 1;
		int move = 1;
		while(r+move <N) {
			if(color == map[r+move][c]) {
				cnt++;
				move++;
			}else {
				break;
			}
		}
		answer = Math.max(cnt, answer);
	}
}
