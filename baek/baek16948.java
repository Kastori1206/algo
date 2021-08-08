package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 데스 나이트 
 * https://www.acmicpc.net/problem/16948
 */
public class baek16948 {
	static class Night {
		int r, c, cnt;

		public Night(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];

		st = new StringTokenizer(br.readLine());
		Night start = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		Night end = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

		Queue<Night> q = new LinkedList<>();
		visited[start.r][start.c] = true;
		q.offer(start);
		while (!q.isEmpty()) {
			Night night = q.poll();
			if (night.r == end.r && night.c == end.c) {
				System.out.println(night.cnt);
				return;
			}

			for (int d = 0; d < 6; d++) {
				int nr = night.r + dr[d];
				int nc = night.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (visited[nr][nc]) {
					continue;
				}

				visited[nr][nc] = true;
				q.offer(new Night(nr, nc, night.cnt + 1));
			}
		}
		System.out.println(-1);
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
