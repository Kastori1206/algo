package programmers;

import java.util.*;

public class P_110옮기기 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {"1110","100111100","0111111010"})));
	}

	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		StringBuilder sb;

		for (int i = 0; i < s.length; i++) {
			String str = s[i];
			Stack<Character> stack = new Stack<>();
			int cnt = 0;

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (stack.size() >= 2) {
					char b = stack.pop();
					char a = stack.pop();

					if (a == '1' && b == '1' && c == '0') {
						cnt++;
						continue;
					} else {
						stack.push(a);
						stack.push(b);
						stack.push(c);
					}
				}

				else {
					stack.push(c);
				}
			}

			int index = stack.size();
			boolean flag = false;
			sb = new StringBuilder();

			while (!stack.isEmpty()) {
				if (!flag && stack.peek() == '1')
					index--;
				if (!flag && stack.peek() == '0')
					flag = true;
				sb.insert(0, stack.pop());
			}

			if (cnt > 0) {
				while (cnt > 0) {
					sb.insert(index, "110");
					index += 3;
					cnt--;
				}
				answer[i] = sb.toString();
			} else {
				answer[i] = s[i];
			}
		}

		return answer;
	}
}
