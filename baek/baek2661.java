package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 좋은수열
 * https://www.acmicpc.net/problem/2661
 **/
public class baek2661 {
	static int N;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs("1");
	}

	static void dfs(String s) {
		if (flag) {
			return;
		}

		if (s.length() == N) {
			flag = true;
			System.out.println(s);
		} else {

			for (int i = 1; i <= 3; i++) {
				if (check(s + i)) {
					dfs(s + i);
				}
			}
		}

	}

	private static boolean check(String s) {
		int len = s.length();
		int start = len - 1;
		int end = len;
		for (int i = 1; i <= len / 2; i++) {
			if (s.substring(start - i, end - i).equals(s.substring(start, end))) {
				return false;
			}
			start--;
		}
		return true;
	}
}
