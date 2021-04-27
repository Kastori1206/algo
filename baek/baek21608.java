package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 상어초등학교
 * https://www.acmicpc.net/problem/21608
 */
public class baek21608 {
	static class Point{
		int r, c, blank, w;

		public Point(int r, int c, int blank, int w) {
			super();
			this.r = r;
			this.c = c;
			this.blank = blank;
		}
		
	}
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	static int[][] map;
	static int N; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i =0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				
			}
		}
		
		
	}
	public static Point check() {
		Point p = null;
		for(int r =0;r<N;r++) {
			for(int c =0;c<N;c++) {
				Point temp = new Point(r,c,0,0);
				int blank  =0;
				int w =0;
				for(int d =0;d<8;d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					
					if(nr<0 || nr>=N || nc<0|| nc>=N) {
						continue;
					}
					if(map[nr][nc]!=0) {
						continue;
					}
					blank++;
					if()
				}
			}
		}
		return p;
	}
}
