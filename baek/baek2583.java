package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek2583 {
	static class Point{
		int r, c, area;

		public Point(int r, int c, int area) {
			super();
			this.r = r;
			this.c = c;
			this.area = area;
		}
		
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] map, visited;
	static int R,C,K, domain;
	static List<Integer> area;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[R][C];
		visited = new boolean[R][C];
		area = new ArrayList<Integer>();
		for(int i =0;i<K;i++) {
			int r1, r2, c1, c2;
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			for(int r= r1; r<=r2;r++) {
				for(int c=c1;c<=c2;c++) {
					if(map[r][c]) {
						continue;
					}
					map[r][c] = true;
				}
			}
		}
		for(int r =0;r<R;r++) {
			for(int c =0;c<C;c++) {
				if(map[r][c]) {
					continue;
				}
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(r,c,1));
				visited[r][c] = true;
				
				for()
				
			}
		}
		
		
	}
	static boolean isIn(int r, int c ) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
