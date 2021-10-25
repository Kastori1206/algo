package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 출근 기록 
 * https://www.acmicpc.net/problem/14238
 */

public class baek14238 {
	static boolean[][][][][] dp;
	static int[] count;
	static char[] answer;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		dp = new boolean[51][51][51][3][3];

		answer = new char[str.length() + 1];
		count = new int[3];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'A') {
				count[0]++;
			} else if (ch == 'B') {
				count[1]++;
			} else {
				count[2]++;
			}
		}
		dfs(0, 0, 0, 0, 0);
		if (!flag) {
			System.out.println(-1);
		}

	}

	static void dfs(int a, int b, int c, int pre1, int pre2) {
		if (flag) {
			return;
		}

		if (a == count[0] && b == count[1] && c == count[2]) {
			StringBuilder sb = new StringBuilder();
			for (char ch : answer) {
				sb.append(ch);
			}
			System.out.println(sb.toString());
			flag = true;
			return;
		}

		if (dp[a][b][c][pre1][pre2]) {
			return;
		}

		dp[a][b][c][pre1][pre2] = true;

		int idx = a + b + c;
		if (a + 1 <= count[0]) {
			answer[idx] = 'A';
			dfs(a + 1, b, c, pre2, 0);
		}
		if (b + 1 <= count[1] && pre2 != 1) {
			answer[idx] = 'B';
			dfs(a, b + 1, c, pre2, 1);
		}
		if (c + 1 <= count[2] && pre1 != 2 && pre2 != 2) {
			answer[idx] = 'C';
			dfs(a, b, c + 1, pre2, 2);
		}

	}

}
