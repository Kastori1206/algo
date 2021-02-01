package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 음식물 피하기
 * https://www.acmicpc.net/problem/1743
 */
public class baek1743 {
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R, C, K, MAX;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Point> wastes = new ArrayList<>();
		map = new int[R+1][C+1];
		visited = new boolean[R+1][C+1];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			wastes.add(new Point(r,c));
			map[r][c] = 1;
		}
		MAX = Integer.MIN_VALUE;
		for(int i=0;i<K;i++) {
			int size =1;
			Point start = wastes.get(i);
			bfs(start, size);
		}
		
		System.out.println(MAX);
	}
	private static void bfs(Point start, int size) {
		Queue<Point> q = new LinkedList<>();
		visited[start.r][start.c] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d =0; d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(map[nr][nc] ==0) {
					continue;
				}
				if(visited[nr][nc]) {
					continue;
				}
				
				visited[nr][nc] = true;
				q.add(new Point(nr, nc));
				size++;
			}
		}
		MAX = Math.max(MAX, size);
	}
	private static boolean isIn(int r, int c) {
		return r>0 && c>0 && r<=R && c<=C;
	}
}
