package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 영역 구하기
 * https://www.acmicpc.net/problem/2583
 */
public class baek2583 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] map, visited;
	static int R, C, K, domain;
	static List<Integer> areas;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[R][C];
		visited = new boolean[R][C];
		areas = new ArrayList<Integer>();
		for (int i = 0; i < K; i++) {
			int r1, r2, c1, c2;
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					if (map[r][c]) {
						continue;
					}
					map[r][c] = true;
				}
			}
		}
	
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] || visited[r][c]) {
					continue;
				}
				domain++;
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(r, c));
				visited[r][c] = true;
				int area = 1;
				while (!q.isEmpty()) {
					Point p = q.poll();

					for (int d = 0; d < 4; d++) {
						int nr = p.r + dr[d];
						int nc = p.c + dc[d];

						if (!isIn(nr, nc)) {
							continue;
						}
						if (visited[nr][nc]) {
							continue;
						}
						if (map[nr][nc]) {
							continue;
						}
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc));
						area++;
					}
				}
				areas.add(area);
			}
		}
		System.out.println(domain);
		Collections.sort(areas);
		for (Integer area : areas) {
			System.out.print(area + " ");
		}
	}

	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
