package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4615 {
	//상,하,좌,우,우상,우하,좌상,좌하
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int N, c;
	static int[][] map;
	static void go(int x, int y, int i) {
		int nx =x+dx[i];int ny=y+dy[i];
		if( nx<1 || nx>N ) return ;
		if( ny<1 || ny>N ) {
			return;
		}
		if( map[nx][nx] == 0 ) return ;
		if( map[ny][nx] == c ) {
			map[y][x] = c;

		}		
	}
//	static void stone(int x, int y) {
//		map[y][x] = c;
//		// up-left-down-right
//		backtrackFlip(x, y-1, 0,-1);
//		backtrackFlip(x-1, y,-1, 0);
//		backtrackFlip(x, y+1, 0, 1);
//		backtrackFlip(x+1, y, 1, 0);
//		// rightup-rightdown-leftup-leftdown
//		backtrackFlip(x+1, y-1, 1,-1);
//		backtrackFlip(x+1, y+1, 1, 1);
//		backtrackFlip(x-1, y-1,-1,-1);
//		backtrackFlip(x-1, y+1,-1, 1);
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int T = Integer.parseInt(st.nextToken());
		System.out.println(T);
		for(int test_case = 1 ; test_case<=T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //한변의 길이
			int M = Integer.parseInt(st.nextToken()); //돌을 놓는 횟수
			int black= 0;
			int white= 0;
			map = new int[N+1][N+1]; //오셀로판
			//판 초기화
			map[N/2][N/2] = map[N/2+1][N/2+1] = 2;
			map[N/2+1][N/2] = map[N/2][N/2+1] = 1;
			//흑돌 1, 백돌 2
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());	
				for(int j=0;j<8;j++) {
					go(x,y,j);
				}
        				
			}
			for(int j =1;j<=N;j++) {
				for(int k =1;k<=N;k++) {
					if(map[j][k] ==1) {
						black++;
					}else if(map[j][k]==2){
						white++;
					}
				}
			}	
			
			System.out.println(String.format("#%d %d %d", test_case, black,white));
		}	
	}
}








