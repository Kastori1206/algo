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
	}

	static public int[] solution(String[] gems) {
		int[] answer = new int[2];
		//구간 안에 보석의 수량 파악
		Map<String, Integer> buy = new HashMap<>();
		//보석의 종류
		Set<String> jewelrys = new HashSet<>();

		int len = gems.length;
		//보석 종류 구하기
		for (int i = 0; i < len; i++) {
			if (jewelrys.contains(gems[i])) {
				continue;
			}
			jewelrys.add(gems[i]);
		}
		//보석 종류가 하나이면 1,1		
		if (jewelrys.size() == 1) {
			answer[0] = 1;
			answer[1] = 1;
			return answer;
		}

		int start = 0;
		int end = 0;
		int index = len;//최소 구간의 처음 시작점
		int min = Integer.MAX_VALUE; //구간의 최소 길이
		
		while (start < len) {
			//구간의 길이가 최소값 보다 작고 끝점이 총길이만큼 갔을 때 
			if (end - start + 1 > min || end == len) {
				String jewelry = gems[start];
				if (buy.get(jewelry) == 1) {
					buy.remove(gems[start]);
				} else {
					buy.merge(jewelry, 1, (existValue, initValue) -> existValue - initValue);

				}
				start++;
			} else {//아니면 끝점을 늘리고 보석 수 추가
				String jewelry = gems[end];
				buy.merge(jewelry, 1, (existValue, initValue) -> existValue + initValue);
				end++;
			}
			//구간안에 보석이 다 있는지 확인
			if (buy.size() == jewelrys.size()) {
				//구간의 길이가 최소구간보다 작으면
				if (min > end - start) {
					min = end - start;
					index = start;
				}
				//같으면 최소 구간 인덱스 확인(작은 값 찾기)
				else if (end - start == min) {
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
}
