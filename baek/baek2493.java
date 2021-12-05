package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 탑
 * https://www.acmicpc.net/problem/2493
 */
public class baek2493 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();

		st = new StringTokenizer(br.readLine());
		stack.push(new int[] { 100000005, 0 });
		for (int i = 1; i <= N; i++) {
			int x = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek()[0] < x) {
				stack.pop();
			}
			answer.append(stack.peek()[1] + " ");
			stack.push(new int[] { x, i });
		}

		System.out.println(answer.toString());

	}
}
