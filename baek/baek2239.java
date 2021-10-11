package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 스도쿠
 * https://www.acmicpc.net/problem/2239
 */

public class baek2239 {
	static int[][] map;
	static StringBuilder answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		answer = new StringBuilder();
		for (int r = 0; r < 9; r++) {
			String str = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		dfs(0,0);
	}

	public static void dfs(int row, int col) {
		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}
		if (row == 9) {
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					answer.append(map[r][c]);
				}
				answer.append("\n");
			}
			System.out.println(answer.toString());
			System.exit(0);
		}

		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (check(row, col, i)) {
					map[row][col] = i;
					dfs(row, col + 1);
				}
			}
			map[row][col] = 0;
			return;
		}
		dfs(row, col + 1);
	}

	static boolean check(int row, int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == value) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][col] == value) {
				return false;
			}
		}

		int startR = (row / 3) * 3;
		int startC = (col / 3) * 3;

		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if (map[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}

}
