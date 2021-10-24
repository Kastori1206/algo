package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 마법사 상어와 파이어스톰 
 * https://www.acmicpc.net/problem/20058
 */
public class baek20058 {
	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node{" + "r=" + r + ", c=" + c + '}';
		}
	}

	static int N, Q, L, len, sum;
	static int[] answer;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		len = (int) Math.pow(2, N);

		map = new int[len][len];
		for (int r = 0; r < len; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < len; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		answer = new int[2];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < Q; i++) {
			L = Integer.parseInt(st.nextToken());
			rotate((int) Math.pow(2, L));
			melt();
		}
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				answer[0] += map[r][c];
			}
		}
		visited = new boolean[len][len];
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				if (visited[r][c] || map[r][c] == 0) {
					continue;
				}
				bfs(r, c);
			}
		}
		System.out.println(answer[0]);
		System.out.println(answer[1]);

	}

	private static void rotate(int n) {
		int[][] map2 = new int[len][len];
		// 배열 90도 시계방향 회전시키기
		for (int r = 0; r < len; r += n) {
			for (int c = 0; c < len; c += n) {
				int sr = r;
				int sc = c;
				for (int cc = c; cc < c + n; cc++) {
					sc = c;
					for (int rr = r + n - 1; rr >= r; rr--) {
						map2[sr][sc++] = map[rr][cc];
					}
					sr++;
				}
			}
		}

		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				map[r][c] = map2[r][c];
			}
		}

	}

	// 얼음 녹이기
	static void melt() {
		Queue<Node> q = new LinkedList<>();
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				if (map[r][c] == 0) {
					continue;
				}
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					if (map[nr][nc] <= 0) {
						continue;
					}
					cnt++;
				}
				if (cnt < 3) {
					q.offer(new Node(r, c));
				}
			}
		}
		while (!q.isEmpty()) {
			Node node = q.poll();

			if (map[node.r][node.c] > 0) {
				map[node.r][node.c]--;
			}
		}
	}

	static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(r, c));
		visited[r][c] = true;
		int size = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}
				if (map[nr][nc] <= 0) {
					continue;
				}
				size++;
				visited[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}

			answer[1] = Math.max(answer[1], size);
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < len && c < len;
	}

	static void print() {
		System.out.println("============");
		for (int[] ints : map) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}
}
