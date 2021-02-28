package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 로봇 청소기
 * acmicpc.net/problem/4991
 */
public class baek4991 {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	static char[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static boolean[] isSelect;
	static int R, C, answer, size;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Point[] dusts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0) {
				break;
			}
			map = new char[R][C];
			dusts = new Point[11];
			dist = new int[11][11];
			size = 1;
			answer = Integer.MAX_VALUE;

			for (int r = 0; r < R; r++) {
				String temp = br.readLine();
				for (int c = 0; c < C; c++) {
					char ch = temp.charAt(c);
					if (ch == 'o') {
						dusts[0] = new Point(r, c);
					} else if (ch == '*') {
						dusts[size++] = new Point(r, c);
					}
					map[r][c] = ch;
				}
			}
		
			isSelect = new boolean[size];
			if (isPossible()) {
				permutation(0, 0, 0);
				System.out.println(answer);
			} else {
				System.out.println(-1);
			}
		}
	}

	private static boolean isPossible() {
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int d = bfs(dusts[i], dusts[j]);
				if (d == -1) {
					return false;
				} else {
					dist[i][j] = dist[j][i] = d;
				}
			}
		}
		return true;
	}

	private static int bfs(Point start, Point end) {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[R][C];
		q.add(start);
		visited[start.r][start.c] = true;

		int result = 0;
		while (!q.isEmpty()) {
			int qSize = q.size();
			++result;
			
			while (qSize-- > 0) {
				Point dust = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = dust.r + dr[d];
					int nc = dust.c + dc[d];
					
					if (!isIn(nr, nc)) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					if (map[nr][nc] == 'x') {
						continue;
					}
					if (nr == end.r && nc == end.c) {
						return result;
					}
					visited[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}
		return -1;
	}

	private static void permutation(int now, int cnt, int sum) {
		if (cnt == size - 1) {
			answer = Math.min(answer, sum);
			return;
		}
		for (int i = 1; i < size; i++) {
			if (isSelect[i]) {
				continue;
			}
			isSelect[i] = true;
			permutation(i, cnt + 1, sum + dist[now][i]);
			isSelect[i] = false;
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
