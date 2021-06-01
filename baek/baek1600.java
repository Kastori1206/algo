package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 말이 되고픈 원숭이
 * https://www.acmicpc.net/problem/1600
 */
public class baek1600 {
	static class Monkey {
		int r, c, k, cnt;

		public Monkey(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}

	}

	static int K, H, W;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] ddr = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] ddc = { -2, -2, -2, -1, 1, 2, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;
		int[][] map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][K + 1];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Monkey> q = new LinkedList<>();

		q.add(new Monkey(0, 0, 0, 0));

		while (!q.isEmpty()) {
			Monkey m = q.poll();
			if (m.r == H - 1 && m.c == W - 1) {
				System.out.println(m.cnt);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = m.r + dr[d];
				int nc = m.c + dc[d];
				if (!isIn(nr, nc)) {
					continue;
				}
				if (visited[nr][nc][m.k]) {
					continue;
				}
				if (map[nr][nc] == 1) {
					continue;
				}
				visited[nr][nc][m.k] = true;
				q.add(new Monkey(nr, nc, m.k, m.cnt + 1));
			}
			if (m.k + 1 <= K) {
				for (int d = 0; d < 8; d++) {
					int nr = m.r + ddr[d];
					int nc = m.c + ddc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					if (visited[nr][nc][m.k + 1]) {
						continue;
					}
					if (map[nr][nc] == 1) {
						continue;
					}

					visited[nr][nc][m.k + 1] = true;
					q.add(new Monkey(nr, nc, m.k + 1, m.cnt + 1));
				}
			}
		}
		System.out.println(-1);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}
}
