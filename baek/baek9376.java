package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 탈옥
 * https://www.acmicpc.net/problem/9376
 */
public class baek9376 {
	static class Point implements Comparable<Point> {
		int r, c, key;//좌표 r, c, 문을 연 수

		public Point(int r, int c, int key) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", key=" + key + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.key, o.key);
		}
	}

	static int R, C, answer;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][][] dist;
	static Point[] persons;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R + 2][C + 2];//지도
			dist = new int[R + 2][C + 2][3];//방문체크 및 거리 계산
			persons = new Point[3]; //상근이, 죄수 1, 죄수 2

			answer = Integer.MAX_VALUE;
			persons[0] = new Point(0, 0, 0); // 상근이
			int index = 1;
			for (int i = 0; i <= R + 1; i++) {
				Arrays.fill(map[i], '.');
			}

			for (int r = 0; r <= R + 1; r++) {
				for (int c = 0; c <= C + 1; c++) {
					Arrays.fill(dist[r][c], -1);
				}
			}

			for (int r = 1; r <= R; r++) {
				String temp = br.readLine();
				for (int c = 1; c <= C; c++) {
					map[r][c] = temp.charAt(c - 1);
					if (map[r][c] == '$') {
						map[r][c] = '.';
						persons[index++] = new Point(r, c, 0);// 죄수 추가
					}
				}
			}

			bfs();

			for (int r = 0; r <= R + 1; r++) {
				for (int c = 0; c <= C + 1; c++) {
					if (map[r][c] == '*') {
						continue;
					}
					int sum = dist[r][c][0] + dist[r][c][1] + dist[r][c][2];
					if (map[r][c] == '#') {
						sum -= 2; // 문이면 세번 더했으니 -2
					}
					// 갈수 없는길은 제외
					if (sum >= 0) {
						continue;
					}
					answer = Math.min(answer, sum);
				}
			}

			System.out.println(answer);
		}

	}

	private static void bfs() {
		for (int i = 0; i < 3; i++) {
			PriorityQueue<Point> q = new PriorityQueue<>();
			int r = persons[i].r;
			int c = persons[i].c;

			q.add(new Point(r, c, 0));
			dist[r][c][i] = 0;

			while (!q.isEmpty()) {
				Point p = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					if (map[nr][nc] == '*') {
						continue;
					}
					if (dist[nr][nc][i] != -1) {
						continue;
					}
					if (map[nr][nc] == '#') {
						q.add(new Point(nr, nc, p.key + 1));
						dist[nr][nc][i] = dist[p.r][p.c][i] + 1;
					} else {
						q.add(new Point(nr, nc, p.key));
						dist[nr][nc][i] = dist[p.r][p.c][i];
					}
				}
			}
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r <= R + 1 && c <= C + 1;
	}
}
