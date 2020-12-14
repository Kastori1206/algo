package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 드래곤 커브
 * https://www.acmicpc.net/problem/15685
 * 시뮬레이션
 */
public class baek15685 {
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int N;

	static boolean[][] map;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new boolean[101][101];
		N = Integer.parseInt(br.readLine());
		int ans = 0;

		int x, y, d, g;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());

			makeDragonCurve(x, y, d, g);

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

	private static void makeDragonCurve(int x, int y, int d, int g) {
		list = new ArrayList<>();
		list.add(d);
		for (int i = 1; i <= g; i++) {
			for (int j = list.size() - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}

		map[y][x] = true;
		for (Integer i : list) {
			y += dy[i];
			x += dx[i];
			map[y][x] = true;
		}
	}
}
