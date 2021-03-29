package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 모래성
 * https://www.acmicpc.net/problem/10711
 */
public class baek10711 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1};
	static int R,C,answer;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		
		Queue<Point> q = new LinkedList<>();
		for (int r = 0; r < R; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if(temp[c] =='.') {
					map[r][c] = 0;
					q.offer(new Point(r,c));
				}else {
					map[r][c] = temp[c]-'0';
				}
				
			}
		}
		answer = 0;
		
		/*
		 * - 파도가 영향을 끼칠수 있는 모래성을 1씩 깍고 버린다
		 * - 강도가 0이되면 큐에 추가한다
		 */
		while (true) {
			int size = q.size();
			for(int i =0;i<size;i++) {
				Point p  = q.poll();
				
				for(int d=0;d<8;d++) {
					int nr = p.r+ dr[d];
					int nc = p.c+ dc[d];
					
					if(!isIn(nr, nc)) {
						continue;
					}
					map[nr][nc]--;
					if(map[nr][nc] ==0) {
						q.offer(new Point(nr,nc));
					}					
				}
			}
			if(q.isEmpty()) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
	}

	
	
	private static boolean isIn(int r, int c) {
		return r>=0 &&c>=0 && r<R&& c<C;
	}

}
