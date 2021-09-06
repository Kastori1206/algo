package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 수식 최대화 
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */
public class 수식최대화 {
	static List<String> nums;
	static List<String> ops;
	static long answer;

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));
	}

	public static long solution(String expression) {
		nums = Arrays.asList(expression.split("[*\\-+]"));
		ops = Arrays.asList(expression.replaceAll("[^*\\-+]", "").split(""));
		Set<String> set = new HashSet<>(ops);
		String[] priority = new String[set.size()];
		int idx = 0;
		for (String key : set) {
			priority[idx++] = key;
		}

		permutation(priority, 0, priority.length, priority.length);

		return answer;
	}

	public static long calc(String[] priority) {
		List<String> copyNums = new ArrayList<>(nums);
		List<String> copyOps = new ArrayList<>(ops);

		for (int i = 0; i < priority.length; i++) {
			for (int j = 0; j < copyOps.size(); j++) {
				if (priority[i].equals(copyOps.get(j))) {
					long a = Long.parseLong(copyNums.remove(j));
					long b = Long.parseLong(copyNums.remove(j));
					long temp = 0;
					switch (priority[i]) {
					case "+":
						temp = a + b;
						break;
					case "-":
						temp = a - b;
						break;
					case "*":
						temp = a * b;
						break;
					}
					copyNums.add(j, String.valueOf(temp));
					copyOps.remove(j);
					j--;
				}
			}
		}

		return Math.abs(Long.parseLong(copyNums.get(0)));
	}

	public static void permutation(String[] arr, int depth, int n, int r) {
		if (depth == r) {
			answer = (long) Math.max(answer, calc(arr));
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}

	static void swap(String[] arr, int depth, int i) {
		String temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

}
