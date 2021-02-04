package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상범 빌딩
 * https://www.acmicpc.net/problem/6593
 */
public class baek6593 {
	static class Point {
		int l, r, c, m;

		public Point(int l, int r, int c, int m) {
			super();
			this.l = l;
			this.r = r;
			this.c = c;
			this.m = m;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				return p.l == l && p.r == r && p.c == c;
			}
			return super.equals(obj);
		}

		@Override
		public String toString() {
			return "Point [l=" + l + ", r=" + r + ", c=" + c + ", m=" + m + "]";
		}

	}

	static char[][][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = { 0, 0, -1, 1 };
	static int[] dl = { 1, 0, -1 }; // 위, 그대로, 아래
	static int answer, L, R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			map = new char[L][R][C];
			visited = new boolean[L][R][C];

			answer = Integer.MAX_VALUE;

			Point start = null, end = null;
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String temp = br.readLine();
					if (temp.equals("")) {
						temp = br.readLine();
					}
					map[l][r] = temp.toCharArray();
					for (int c = 0; c < C; c++) {
						if (map[l][r][c] == 'S') {
							start = new Point(l, r, c, 0);
						} else if (map[l][r][c] == 'E') {
							end = new Point(l, r, c, 0);
						}
					}
				}
			}
			bfs(start, end);
			if (answer != Integer.MAX_VALUE) {
				System.out.println("Escaped in " + answer + " minute(s).");
			} else {
				System.out.println("Trapped!");
			}
		}
	}

	private static void bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		visited[start.l][start.r][start.c] = true;
		q.add(start);
		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.equals(end)) {
				answer = Math.min(answer, p.m);
				return;
			}

			for (int l = 0; l < 3; l++) {
				for (int d = 0; d < 4; d++) {
					int nl = p.l + dl[l];
					int nr = p.r;
					int nc = p.c;
					// 상 하 좌 우 움직일수있을 때
					if (l == 1) {
						nr = p.r + dr[d];
						nc = p.c + dc[d];
					}

					if (!isIn(nl, nr, nc)) {
						continue;
					}
					if (visited[nl][nr][nc]) {
						continue;
					}
					if (map[nl][nr][nc] == '#') {
						continue;
					}

					visited[nl][nr][nc] = true;
					q.add(new Point(nl, nr, nc, p.m + 1));
				}
			}
		}
	}

	private static boolean isIn(int l, int r, int c) {
		return l >= 0 && r >= 0 && c >= 0 && l < L && r < R && c < C;
	}
}
