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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int T = Integer.parseInt(st.nextToken());
		
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
				map[y][x] = c;
				for(int j=0;j<8;j++) {
					int nx = x; int ny =y;
					int cnt =0;
					while(true) {
						nx =nx+dx[j]; ny=ny+dy[j];						
						if( nx<1 || nx>N ) {
							break;
						}
						if( ny<1 || ny>N ) {
							break;
						}
						if( map[ny][nx] == 0 ) {
							break;						
						}
						if( map[ny][nx] == c ) {							
							for(int k=1;k<=cnt;k++) {
								map[y+dy[j]*k][x+dx[j]*k] = c;
							}
							break;
						}
						cnt++;
					}				
				}				
			}
			for(int i =1;i<=N;i++) {
				for(int j =1;j<=N;j++) {
					if(map[i][j] ==1) {
						black++;
					}else if(map[i][j]==2){
						white++;
					}
				}
			}			
			
			System.out.println(String.format("#%d %d %d", test_case, black,white));
		}	
	}
}








