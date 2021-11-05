package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 배열에서 이동 
 * https://www.acmicpc.net/problem/1981
 */
public class baek1981 {
	static class Node {
		int r, c;

		protected Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int N, answer, max, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c] = num;
				max = Math.max(num, max);
				min = Math.min(num, min);
			}
		}
		//정답은 최대값 - 최소값 사이의 값이다.
		binarySerach(0, max - min);
		System.out.println(answer);
	}

	private static void binarySerach(int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (bfs(mid)) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

	}
	//최대값 최소값 사이의 경로로 n-1, n-1까지 갈수있는지 확인
	private static boolean bfs(int mid) {
		for (int i = min; i + mid <= max; i++) {
			int start = i;
			int end = start + mid;

			if (start > map[0][0] || map[0][0] > end) {
				continue;
			}

			Queue<Node> q = new LinkedList<>();
			visited = new boolean[N][N];
			q.offer(new Node(0, 0));
			visited[0][0] = true;

			while (!q.isEmpty()) {
				Node cur = q.poll();

				if (cur.r == N - 1 && cur.c == N - 1) {
					return true;
				}

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					if (start > map[nr][nc]) {
						continue;
					}
					if (end < map[nr][nc]) {
						continue;
					}

					visited[nr][nc] = true;
					q.offer(new Node(nr, nc));
				}
			}
		}

		return false;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
