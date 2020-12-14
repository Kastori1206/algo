package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek1261 {
	static class Point implements Comparable<Point>{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}

	static int R, C, answer;
	static int[][] map, dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dist = new int[R][C];
		answer = 0;
		
		for (int r = 0; r < R; r++) {
			String temp = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c) - '0';
				dist[r][c] = Integer.MAX_VALUE;
			}
		}

		bfs(new Point(0, 0, 0));
		System.out.println(answer);
	}

	static void bfs(Point p) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(p);
		dist[p.r][p.c] = 0;
		
		while (!pq.isEmpty()) {
			Point temp = pq.poll();
			if(temp.r == R-1 && temp.c == C-1) {
				answer = temp.cnt;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = temp.r + dr[d];
				int nc = temp.c + dc[d];
				if (!isIn(nr, nc)) {
					continue;
				}
			
				if(dist[nr][nc] > dist[temp.r][temp.c] + map[nr][nc]) {
					dist[nr][nc] = dist[temp.r][temp.c]+ map[nr][nc]; 
					pq.add(new Point(nr,nc, dist[temp.r][temp.c] + map[nr][nc] ));
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
