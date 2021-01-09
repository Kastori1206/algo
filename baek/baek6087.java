package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek6087 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][] visited;
	static int R , C , result;
	static class Point{
		int r, c, d;
		

		public Point(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;			
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited =new boolean[R][C];		
		Point[] points = new Point[2];
		int cnt = 0;
		for(int r=0;r<R;r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c<C;c++) {
				if(map[r][c] == 'C') {
					points[cnt++] = new Point(r,c,-1);					
				}
			}			
		}
		
		bfs(points[0],points[1]);
		
	}
	private static void bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.r == end.r && p.c == end.c) {
				//연결
			}
			
			for(int d = 0;d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(visited[nr][nc]) {
					continue;
				}
				if(map[nr][nc] != '.') {
					continue;
				}
				
				
				
			}
			
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
