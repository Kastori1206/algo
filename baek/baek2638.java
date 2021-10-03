package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 치즈 https://www.acmicpc.net/problem/2638
 */
public class baek2638 {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[][] map;
	static boolean[][] air;
	static int R, C, answer;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Node> cheeze;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		air = new boolean[R][C];
		cheeze = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					cheeze.add(new Node(r, c));
				}
			}
		}
		while (!cheeze.isEmpty()) {
			checkAir();
			removeCheeze();
			answer++;
		}
		System.out.println(answer);
	}

	public static void removeCheeze() {
		Iterator<Node> iter = cheeze.iterator();
		while (iter.hasNext()) {
			Node cur = iter.next();

			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (!air[nr][nc]) {
					continue;
				}
				cnt++;
			}
			if (cnt >= 2) {
				map[cur.r][cur.c] = 0;
				iter.remove();
			}
		}
	}

	public static void checkAir() {
		Queue<Node> q = new LinkedList<>();
		air = new boolean[R][C];
		q.offer(new Node(0, 0));
		air[0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (air[nr][nc]) {
					continue;
				}
				if (map[nr][nc] == 1) {
					continue;
				}
				air[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
