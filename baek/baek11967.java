package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 불켜기 
 * https://www.acmicpc.net/problem/11967
 */
public class baek11967 {
	static class Node {
		int r, c;

		protected Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static boolean[][] switched;
	static List<Node>[][] map;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new ArrayList[N + 1][N + 1];
		for (int r = 0; r <= N; r++) {
			for (int c = 0; c <= N; c++) {
				map[r][c] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			map[y1][x1].add(new Node(y2, x2));
		}
		visited = new boolean[N + 1][N + 1];
		switched = new boolean[N + 1][N + 1];

		System.out.println(bfs() + 1);
	}

	static int bfs() {
		int res = 0;
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(1, 1));

		for (int r = 0; r <= N; r++) {
			Arrays.fill(visited[r], false);
		}
		visited[1][1] = true;
		switched[1][1] = true;

		boolean flag = false;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (Node next : map[cur.r][cur.c]) {
				if (!switched[next.r][next.c]) {
					switched[next.r][next.c] = true;
					res++;
					flag = true;
				}
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if (!isIn(nr, nc)) {
					continue;
				}
				if (!switched[nr][nc]) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}

				q.offer(new Node(nr, nc));
				visited[nr][nc] = true;
			}
		}
		if (flag) {
			res += bfs();
		}
		return res;
	}

	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= N && c <= N;
	}
}
