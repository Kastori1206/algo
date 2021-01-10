package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 레이저 통신
 * https://www.acmicpc.net/problem/6087
 * BFS
 */
public class baek6087 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static int[][] dist;
	static int R , C ;
	static class Point implements Comparable<Point>{
		int r, c, d, cnt;
		public Point(int r, int c, int d, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;			
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cnt, o.cnt);
		}		
	
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		dist =new int[R][C];		
		Point[] points = new Point[2];
		
		int cnt =0;
		for(int r=0;r<R;r++) {
			Arrays.fill(dist[r], R*C);
			map[r] = br.readLine().toCharArray();			
			for(int c = 0; c<C;c++) {
				if(map[r][c] == 'C') {
					points[cnt++] = new Point(r,c,-1,0);					
				}
			}			
		}		
		
		System.out.println(bfs(points[0],points[1]));
	}
	private static int bfs(Point start, Point end) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(start);
		dist[start.r][start.c] = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();

			if(p.r == end.r && p.c == end.c) {				
				return p.cnt;
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
				
				if(p.d == d || p.d == -1) {
					if(dist[nr][nc] >= p.cnt) {
						dist[nr][nc] = p.cnt;
						q.offer(new Point(nr,nc,d,p.cnt));
					}
				}else {
					if(dist[nr][nc]>= p.cnt +1) {
						dist[nr][nc] = p.cnt +1;
						q.add(new Point(nr, nc,d,p.cnt+1));
					}
				}
				
			}
		}
		return -1;
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
