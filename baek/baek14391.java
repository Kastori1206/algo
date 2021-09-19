package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 종이 조각
 * https://www.acmicpc.net/problem/14391
 */
public class baek14391 {
	static int R, C, answer;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			String temp = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = temp.charAt(c) - '0';
			}
		}
		int max = getTotal();
		System.out.println(max);
	}

	public static int getTotal() {
		int max = 0;
		for (int i = 0; i < (1 << (R * C)); i++) {
			int sum = 0;
			sum += getHori(i);
			sum += getVert(i);
			max = Math.max(max, sum);
		}
		return max;
	}

	public static int getHori(int n) {
		int sum = 0;
		for (int r = 0; r < R; r++) {
			int temp = 0;
			for (int c = 0; c < C; c++) {
				if ((n & (1 << r * C + c)) != 0) {
					temp *= 10;
					temp += map[r][c];
				} else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		return sum;
	}

	public static int getVert(int n) {
		int sum = 0;
		for (int c = 0; c < C; c++) {
			int temp = 0;
			for (int r = 0; r < R; r++) {
				if ((~n & (1 << r * C + c)) != 0) {
					temp *= 10;
					temp += map[r][c];
				} else {
					sum += temp;
					temp = 0;
				}
			}
			sum += temp;
		}
		return sum;
	}
}
