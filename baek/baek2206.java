package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 벽 부수고 이동하기
 * https://www.acmicpc.net/problem/2206
 * BFS
 */

public class baek2206 {
	static class Point {
		int r, c, d;
		boolean flag; // 벽을 부순적이 있는지 없는지

		public Point(int r, int c, int d, boolean flag) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.flag = flag;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", d=" + d + ", flag=" + flag + "]";
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][][] visited;
	static int R, C, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ans = Integer.MAX_VALUE;
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C][2];// 0벽을 부수지 않은 경우, 1 벽을 부순 경우

		for (int r = 0; r < R; r++) {
			String temp = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}

		bfs(0, 0);

		ans = ans == Integer.MAX_VALUE ? -1 : ans;
		System.out.println(ans);
	}

	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		visited[r][c][0] = true;
		visited[r][c][1] = true;
		q.add(new Point(r, c, 1, false));

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (p.r == R - 1 && p.c == C - 1) {
				ans = Math.min(ans, p.d);
			}
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (map[nr][nc] == 1) {
					if (!p.flag && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						q.add(new Point(nr, nc, p.d + 1, true));
					}
				} else {
					int index = p.flag ? 1 : 0;
					if (!visited[nr][nc][index]) {
						visited[nr][nc][index] = true;
						q.add(new Point(nr, nc, p.d + 1, p.flag));
					}
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
