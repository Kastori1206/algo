package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 불
 * https://www.acmicpc.net/problem/5427
 */
public class baek5427 {
	static class Point{
		int r, c, s;

		public Point(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}		
	}
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R, C, answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t =0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visited = new boolean[R][C];
			
			answer = Integer.MAX_VALUE;
			
			Queue<Point> fires = new LinkedList<>();
			Queue<Point> sangguns = new LinkedList<>();
			for(int r =0;r<R;r++) {
				map[r] = br.readLine().toCharArray();
				for(int c = 0 ;c<C;c++) {
					if(map[r][c] == '*') {
						fires.offer(new Point(r,c,0));
					}else if(map[r][c] == '@') {
						sangguns.offer(new Point(r,c,0));
						visited[r][c] = true;
					}
				}
			}
			boolean flag = false;
			while(true) {
				//불 옮겨짐
				int size = fires.size();
				for(int i =0;i<size;i++) {
					Point fire = fires.poll();
					for(int d= 0;d<4;d++) {
						int nr = fire.r + dr[d];
						int nc = fire.c + dc[d];
						
						if(!isIn(nr, nc)) {
							continue;
						}
						if(map[nr][nc]!='.') {
							continue;
						}
						
						map[nr][nc] ='*';
						fires.offer(new Point(nr,nc,0));
					}
				}
				//상근이 이동
				size = sangguns.size();
				for(int i =0;i<size;i++) {
					Point sanggun = sangguns.poll();
					int r = sanggun.r;
					int c = sanggun.c;
					if(r == 0 || r == R-1 ||c ==0||c==C-1) {
						flag = true;
						answer = Math.min(sanggun.s+1, answer);
						break;
					}
					for(int d= 0;d<4;d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(!isIn(nr, nc)) {
							continue;
						}
						if(visited[nr][nc]) {
							continue;
						}
						if(map[nr][nc]!='.') {
							continue;
						}
						visited[nr][nc] = true;
						sangguns.offer(new Point(nr,nc,sanggun.s+1));
					}
				}
				
				
				if(flag) {
					break;
				}else if(sangguns.isEmpty()) {
					break;
				}
				
			}
			
			if(answer == Integer.MAX_VALUE) {
				System.out.println("IMPOSSIBLE");
			}else {
				System.out.println(answer);
			}
			System.out.flush();
		}
		
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c<C;
	}
}
