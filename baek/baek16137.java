package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 견우와 직녀
 * https://www.acmicpc.net/problem/16137
 */
public class baek16137 {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R, C, answer;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int r =0 ; r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0;c<C;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
