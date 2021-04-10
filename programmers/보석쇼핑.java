package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 보석쇼핑 {
	public static void main(String[] args) {
		String[][] gems = new String[][] { { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" },
				{ "AA", "AB", "AC", "AA", "AC" }, { "XYZ", "XYZ", "XYZ" }, { "ZZZ", "YYY", "NNNN", "YYY", "BBB" } };
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(solution(gems[i])));
		}
//	

		System.out.println(Arrays.toString(solution(new String[] { "XYZ", "XYZ", "XYZ" })));
	}

	static public int[] solution(String[] gems) {
		int[] answer = new int[2];
		Map<String, Integer> buy = new HashMap<>();
		Set<String> jewelrys = new HashSet<>();

		int len = gems.length;
		for (int i = 0; i < len; i++) {
			if (jewelrys.contains(gems[i])) {
				continue;
			}
			jewelrys.add(gems[i]);
		}

		if (jewelrys.size() == 1) {
			answer[0] = 1;
			answer[1] = 1;
			return answer;
		}

		int start = 0;
		int end = 0;
		int index = len;
		int min = Integer.MAX_VALUE;

		while(start<len) {
			if (end - start + 1 > min || end == len) {
				String jewelry = gems[start];
				if (buy.get(jewelry) == 1) {
					buy.remove(gems[start]);
				} else {
					buy.merge(jewelry, 1, (existValue, initValue) -> existValue - initValue);

				}
				start++;

			} else {
				String jewelry = gems[end];
				buy.merge(jewelry, 1, (existValue, initValue) -> existValue + initValue);
				end++;
			}
			if (buy.size() == jewelrys.size()) {
				if (min > end - start) {
					min = end - start;
					index = start;
				} else if (end - start == min) {
					if (index > start) {
						index = start;
					}
				}
			}
		}
		answer[0] = index + 1;
		answer[1] = answer[0] + min - 1;
		return answer;
	}

	static boolean check(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) {
				return false;
			}
		}
		return true;
	}
}
