package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2589. 보물섬 
 * https://www.acmicpc.net/problem/2589
 * BFS
 */

public class baek2589 {
	static public class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R, C, ans;
	static int dist[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;
	static List<Point> lands = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		ans = 0;
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0 ;c<C;c++) {
				if(map[r][c]=='L') {
					lands.add(new Point(r,c));
				}
			}
		}
		
		for(int i =0;i<lands.size();i++) {
			Point start = lands.get(i);
			bfs(start);
		}

		System.out.println(ans);
	}

	public static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[R][C];
		dist = new int[R][C];
		
		q.add(start);
		visited[start.r][start.c] = true;
		
		int temp  = 0;
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
				if (map[nr][nc] == 'W') {
					continue;
				}
				visited[nr][nc] = true;
				dist[nr][nc] = dist[p.r][p.c]+1;
				q.add(new Point(nr, nc));
				temp = Math.max(temp, dist[nr][nc]);
			}
		}
		
		ans = Math.max(ans, temp);
		
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
