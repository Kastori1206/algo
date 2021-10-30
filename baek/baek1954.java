package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 움직이는 미로 탈출
 * https://www.acmicpc.net/problem/16954
 */
public class baek1954 {
	static class Node {
		int r, c;

		protected Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + "]";
		}

	}

	static int[] dr = { 0, 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dc = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int answer;
	static List<Node> walls;
	static char[][] map;
	static final int R = 8, C = 8;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		bfs();
		System.out.println(answer);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[8][8];

		q.offer(new Node(7, 0));
		visited[7][0] = true;
		int time = 0;
		while (!q.isEmpty()) {
			visited = new boolean[8][8];
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Node cur = q.poll();
				if (map[cur.r][cur.c] == '#') {
					continue;
				}
				if (time >= 8 || (cur.r == 0 && cur.c == 7)) {
					answer = 1;
					return;
				}
				for (int d = 0; d < 9; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					if (map[nr][nc] == '#') {
						continue;
					}

					if (visited[nr][nc]) {
						continue;
					}

					q.offer(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
			time++;
			move();
		}
	}

	static void move() {
		for (int c = 0; c < 8; c++) {
			map[7][c] = '.';
		}
		for (int r = 6; r >= 0; r--) {
			for (int c = 0; c < 8; c++) {
				if (map[r][c] == '#') {
					map[r][c] = '.';
					map[r + 1][c] = '#';
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
