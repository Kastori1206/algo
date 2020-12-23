package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 알파벳
 * https://www.acmicpc.net/problem/1987
 */
public class baek1987 {
	static int R, C, ans;
	static boolean[] alpha = new boolean[26];
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		ans = 0;
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		alpha[map[0][0]-65] = true;
		go(0, 0,1);
		System.out.println(ans);

	}

	private static void go(int r, int c, int dist) {
		if(dist > 26) {
			return;
		}
		ans = Math.max(ans, dist);
		for(int d = 0; d<4;d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(!isIn(nr, nc)) {
				continue;				
			}
			if(alpha[map[nr][nc]-65]) {
				continue;
			}
			alpha[map[nr][nc]-65] = true;
			go(nr,nc, dist+1);
			alpha[map[nr][nc]-65] = false;
		}
	}
	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
