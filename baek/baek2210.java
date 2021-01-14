package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 숫자판 점프
 * https://www.acmicpc.net/problem/2210
 */
public class baek2210 {
	static class Point{
		int r, c, cnt;
		String str;
		
		
		public Point(int r, int c, int cnt, String str) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.str = str;
		}		
	}
	static int[][] map;
	static int R=5,C=5,answer;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Set<Integer> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[R][C];
		set = new HashSet<>();
		
		
		for(int r =0;r<R;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0 ;c<C;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c = 0;c<C;c++) {
				bfs(r,c);
			}
		}
		answer = set.size();
		System.out.println(answer);
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c,1,""));		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.cnt==7) {
				int num = Integer.parseInt(p.str);
				if(!set.contains(num)) {
					set.add(num);
				}
			}
			for(int d = 0; d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(p.cnt > 6) {
					continue;
				}
				q.offer(new Point(nr,nc,p.cnt+1,p.str+map[nr][nc]));
			}
		}
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>= 0 && r<R&& c<C;
	}
}
