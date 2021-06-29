package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 두 동전
 * https://www.acmicpc.net/problem/16197
 */
public class baek16197 {
	static class Coin {
		int r, c;

		public Coin(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static char[][] map;
	static int R, C, answer;
	static List<Coin> coins;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		coins = new ArrayList<>();
		answer = Integer.MAX_VALUE;

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'o') {
					coins.add(new Coin(r, c));
				}
			}
		}

		go(coins.get(0), coins.get(1), 0);

		answer = answer == Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
	}

	static public void go(Coin coin1, Coin coin2, int cnt) {
		if (cnt >= answer || cnt >= 10) {
			return;
		}
		for (int d = 0; d < 4; d++) {
			int out = 0;
			int nr1 = coin1.r + dr[d];
			int nc1 = coin1.c + dc[d];
			int nr2 = coin2.r + dr[d];
			int nc2 = coin2.c + dc[d];

			if (!isIn(nr1, nc1)) {
				out++;
			}
			if (!isIn(nr2, nc2)) {
				out++;
			}

			if (out == 2) {
				continue;
			}
			if (out == 1) {
				answer = Math.min(answer, cnt + 1);
				return;
			}
			if (map[nr1][nc1] == '#') {
				nr1 = coin1.r;
				nc1 = coin1.c;
			}
			if (map[nr2][nc2] == '#') {
				nr2 = coin2.r;
				nc2 = coin2.c;
			}

			go(new Coin(nr1, nc1), new Coin(nr2, nc2), cnt + 1);
		}
	}

	static public boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
