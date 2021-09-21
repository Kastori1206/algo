package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 괄호 추가하기
 * https://www.acmicpc.net/problem/16637
 */
public class baek16637 {
	static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		answer = Integer.MIN_VALUE;
		dfs(0, 0, str);
		System.out.println(answer);
	}

	public static int calc(int a, int b, char op) {
		int result = a;
		switch (op) {
		case '+':
			result += b;
			break;
		case '-':
			result -= b;
			break;
		case '*':
			result *= b;
			break;
		}
		return result;
	}

	public static void dfs(int idx, int result, String str) {
		if (idx > N - 1) {
			answer = Math.max(answer, result);
			return;
		}
		char op = (idx == 0) ? '+' : str.charAt(idx - 1);

		if (idx + 2 < N) {
			int temp = calc(str.charAt(idx) - '0', str.charAt(idx + 2) - '0', str.charAt(idx + 1));
			dfs(idx + 4, calc(result, temp, op), str);
		}
		dfs(idx + 2, calc(result, str.charAt(idx) - '0', op), str);
	}
}
