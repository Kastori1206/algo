package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek6087 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static int[][] dist;
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
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		dist =new int[R][C];		
		visited = new boolean[R][C];
		Point[] points = new Point[2];
		int cnt = 0;
		for(int r=0;r<R;r++) {
			Arrays.fill(dist[r], -1);
			map[r] = br.readLine().toCharArray();			
			for(int c = 0; c<C;c++) {
				if(map[r][c] == 'C') {
					points[cnt++] = new Point(r,c,-1);					
				}
			}			
		}		
		
		bfs(points[0],points[1]);
		System.out.println(result);
		for(int[] a : dist) {
			for(int b : a) {
				System.out.printf("%3d ",b);
			}
			System.out.println();
		}
	}
	private static void bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		dist[start.r][start.c] = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
//			System.out.println(p);
			if(p.r == end.r && p.c == end.c) {
				//연결
				return;
			}
			
			for(int d = 0;d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
			
				if(map[nr][nc] == '*') {
					continue;
				}
				if(p.d == -1) {
					p.d =d;
					dist[nr][nc] = dist[p.r][p.c];
				}else if(p.d != d) {					
					p.d = d;
					dist[nr][nc] = dist[p.r][p.c]+1; 
				}				
				q.offer(new Point(nr,nc,d));				
			}
		}
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
