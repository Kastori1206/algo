package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬 탈출 2 
 * https://www.acmicpc.net/problem/13460
 */
public class baek13460 {
	static class Node {
		int rr, rc;
		int br, bc;
		int cnt;

		public Node(int rr, int rc, int br, int bc, int cnt) {
			super();
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}
	}

	static int N, M, answer;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Node balls;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];

		answer = -1;
		int r1 = 0, c1 = 0, r2 = 0, c2 = 0;
		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == 'R') {
					r1 = r;
					c1 = c;
				} else if (map[r][c] == 'B') {
					r2 = r;
					c2 = c;
				}
			}
		}
		balls = new Node(r1, c1, r2, c2, 0);
		bfs();
		System.out.println(answer);

	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.offer(balls);

		visited[balls.rr][balls.rc][balls.br][balls.bc] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.cnt > 10) {
				answer = -1;
				return;
			}
			if (map[cur.br][cur.bc] == 'O') {
				continue;
			}
			if (map[cur.rr][cur.rc] == 'O') {
				answer = cur.cnt;
				return;
			}

			for (int d = 0; d < 4; d++) {
				Node next = move(cur, d);

				if (check(next)) {
					//이동거리 긴쪽이 뒤쪽으로 가게 처리
					int rDist = Math.abs(cur.rr - next.rr) + Math.abs(cur.rc - next.rc);
					int bDist = Math.abs(cur.br - next.br) + Math.abs(cur.bc - next.bc);

					if (rDist > bDist) {
						next.rr -= dr[d];
						next.rc -= dc[d];
					} else {
						next.br -= dr[d];
						next.bc -= dc[d];
					}
				}

				if (visited[next.rr][next.rc][next.br][next.bc]) {
					continue;
				}
				visited[next.rr][next.rc][next.br][next.bc] = true;
				q.offer(new Node(next.rr, next.rc, next.br, next.bc, cur.cnt + 1));
			}
		}
	}

	//두개의 위치가 동일한지(빨간색 파란색 겹칠수 없음)
	private static boolean check(Node next) {
		return next.rr == next.br && next.rc == next.bc && map[next.rr][next.rc] != 'O';
	}

	private static Node move(Node cur, int d) {
		// 파란색 볼
		int nbr = cur.br;
		int nbc = cur.bc;

		while (true) {
			nbr += dr[d];
			nbc += dc[d];

			// 탈출한 경우
			if (map[nbr][nbc] == 'O') {
				break;
			}
			// 벽을 만난경우
			else if (map[nbr][nbc] == '#') {
				nbr -= dr[d];
				nbc -= dc[d];
				break;
			}
		}
		// 빨간색 볼
		int nrr = cur.rr;
		int nrc = cur.rc;

		while (true) {
			nrr += dr[d];
			nrc += dc[d];

			// 탈출한 경우
			if (map[nrr][nrc] == 'O') {
				break;
			}
			// 벽을 만난경우
			else if (map[nrr][nrc] == '#') {
				nrr -= dr[d];
				nrc -= dc[d];
				break;
			}
		}
		return new Node(nrr, nrc, nbr, nbc, 0);
	}
}
