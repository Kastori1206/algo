package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses 
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		for (String str : res) {
			System.out.print(str + ", ");
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> answer = new ArrayList<>();
		dfs("", n, 0, 0, answer);
		return answer;
	}

	public static void dfs(String str, int n, int a, int b, List<String> answer) {
		if (a == n && b == n) {
			answer.add(str);
			return;
		}
		if (a < n) {
			dfs(str + "(", n, a + 1, b, answer);
		}
		if (b < a) {
			dfs(str + ")", n, a, b + 1, answer);
		}
	}
}
