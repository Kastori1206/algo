package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 견우와 직녀
 * https://www.acmicpc.net/problem/16137
 */
public class baek16137 {
	static class Point {
		int r, c, t;

		public Point(int r, int c, int t) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
		}

	}

	static int n, m;
	static int[][] map;
	static int[][][] dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		dist = new int[n][n][20];
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = -1;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == 0 && check(r, c)) {
					map[r][c] = m;

					int now = bfs();
					if (now != -1) {
						if (ans == -1 || ans > now) {
							ans = now;
						}
					}
					map[r][c] = 0;
				}
			}
		}
		System.out.println(ans);
	}

	private static boolean check(int r, int c) {
		boolean col = false;
		if (c - 1 >= 0 && map[r][c - 1] == 0) {
			col = true;
		}
		if (c + 1 < n && map[r][c + 1] == 0) {
			col = true;
		}

		boolean row = false;
		if (r - 1 >= 0 && map[r - 1][c] == 0) {
			row = true;
		}
		if (r + 1 < n && map[r + 1][c] == 0) {
			row = true;
		}
		return !(row && col);
	}

	private static int bfs() {
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				Arrays.fill(dist[r][c], -1);
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		dist[0][0][0] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int r = p.r;
			int c = p.c;
			int t = p.t;

			if (map[r][c] >= 2 && t % map[r][c] != 0) {
				int nt = (t + 1) % map[r][c];
				if (dist[r][c][nt] == -1) {
					dist[r][c][nt] = dist[r][c][t] + 1;
					q.add(new Point(r, c, nt));
				}
			} else {
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (isIn(nr, nc)) {
						if (map[r][c] >= 2 && map[nr][nc] >= 2) {
							continue;
						}
						if (map[nr][nc] >= 1) {
							int nt = (dist[r][c][t] + 1) % map[nr][nc];
							if (dist[nr][nc][nt] == -1) {
								dist[nr][nc][nt] = dist[r][c][t] + 1;
								q.add(new Point(nr, nc, nt));
							}
						}

					}

				}
			}
		}
		int ans = -1;
		for (int i = 0; i < 20; i++) {
			if (dist[n - 1][n - 1][i] == -1) {
				continue;
			}
			if (ans == -1 || ans > dist[n - 1][n - 1][i]) {
				ans = dist[n - 1][n - 1][i];
			}
		}
		return ans;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < n;
	}
}
