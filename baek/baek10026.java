package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 적록색약
 * https://www.acmicpc.net/problem/10026
 * BFS
 */
public class baek10026 {
	static int N;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] ans;
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N][2];
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		ans = new int[2];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				//0 이상없는 사람, 1 이상있는사람
				if (visited[r][c][0] && visited[r][c][1]) {
					continue;
				} 
				char color = map[r][c];
				if(!visited[r][c][0]) {
					bfs(r,c,0,color);
					ans[0] ++;
				}
				if(!visited[r][c][1]) {
					bfs(r,c,1,color);
					ans[1] ++;
				}				
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}

	private static void bfs(int r, int c, int flag, char color) {
		Queue<Point> q  = new LinkedList<>();
		visited[r][c][flag] = true;
		q.add(new Point(r,c) );
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int d =0;d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(visited[nr][nc][flag]) {
					continue;
				}
				if(flag==0) {
					if(map[nr][nc] != color) {
						continue;
					}
				}else {
					if(color == 'R' || color=='G') {
						if(map[nr][nc] == 'B') {
							continue;
						}
					}else if(color=='B') {
						if(map[nr][nc] != 'B') {
							continue;
						}
					}
				}
				visited[nr][nc][flag] = true;
				q.add(new Point(nr,nc));
			}			
		}
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
