package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 탈옥
 * https://www.acmicpc.net/problem/9376
 */
public class baek9376 {
	static class Point {
		int r, c, key, i;

		public Point(int r, int c, int key,int i) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.i = i;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", key=" + key + "]";
		}

	}

	static int R, C;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] answer;
	static boolean[][][] visited;
	static Point[] person;
	static Queue<Point> q;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			person = new Point[2];
			map = new char[R][C];
			visited = new boolean[R][C][2];
			answer = new int[2];
			answer[0] = Integer.MAX_VALUE;
			answer[1] = Integer.MAX_VALUE;
			q = new LinkedList<>();
			int index = 0;
			for(int r= 0 ;r<R;r++) {
				map[r] = br.readLine().toCharArray();
				for(int c =0;c<C;c++) {
					if(map[r][c]=='$') {
						visited[r][c][index] = true;
						q.add(new Point(r,c,0,index++));
					}
				}
			}
			bfs();
			if(answer[0] == Integer.MAX_VALUE) {
				answer[0] =0;
			}
			if(answer[1] == Integer.MAX_VALUE) {
				answer[1] =0;
			}
			System.out.println(answer[0]+answer[1]);
		}
		
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while(!q.isEmpty()) {
			Point p = q.poll();
			int index = p.i;
			if(p.r==0 || p.c ==0||p.r==R-1 || p.c==C-1) {
				answer[index] = Math.min(answer[index], p.key);
			}
			
			for(int d =0;d<4;d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(map[nr][nc]=='*') {
					continue;
				}
				if(visited[nr][nc][index]) {
					continue;
				}
				
				if(map[nr][nc]=='#') {
					if(visited[nr][nc][(index+1)%2]) {
						q.add(new Point(nr,nc,p.key,index));
					}else {
						q.add(new Point(nr,nc,p.key+1,index));
						visited[nr][nc][index] = true;
					}
				}
			}
		}
		

	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
