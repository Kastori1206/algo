package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식
 * https://www.acmicpc.net/problem/1918
 */
public class baek1918 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();

		Stack<Character> stack = new Stack<>();
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			int priority = check(ch);

			if (priority >= 1) {
				while (!stack.isEmpty() && check(stack.peek()) >= priority) {
					answer.append(stack.pop());
				}
				stack.push(ch);
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					answer.append(stack.pop());
				}
				stack.pop();
			} else {
				answer.append(ch);
			}

		}
		while (!stack.isEmpty()) {
			answer.append(stack.pop());
		}
		System.out.println(answer.toString());
	}

	public static int check(char ch) {
		if (ch == '*' || ch == '/') {
			return 2;
		} else if (ch == '+' || ch == '-') {
			return 1;
		} else {
			return 0;
		}
	}
}
