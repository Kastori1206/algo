package programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 다트 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */
public class 다트게임 {
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		int answer = 0;
		Pattern pattern = Pattern.compile("[0-9]+[SDT][*#]?");
		Matcher matcher = pattern.matcher(dartResult);
		String[] split = new String[3];

		int idx = 0;
		while (matcher.find()) {
			split[idx++] = matcher.group();
		}
		int[] score = new int[3];
		for (int i = 0; i < 3; i++) {
			String dart = split[i];
			idx = 0;
			for (int j = 0; j < dart.length(); j++) {
				char ch = dart.charAt(j);
				if (!Character.isDigit(ch)) {
					idx = j;
					break;
				}
			}

			int num = idx == 1 ? dart.charAt(0) - '0' : 10;
			int pow = 1;
			if (dart.charAt(idx) == 'D') {
				pow = 2;
			} else if (dart.charAt(idx) == 'T') {
				pow = 3;
			}

			idx++;

			int option = 1;
			if (dart.length() > idx) {
				if (dart.charAt(idx) == '*') {
					option = 2;
				} else if (dart.charAt(idx) == '#') {
					option = -1;
				}
			}

			score[i] = (int) (Math.pow(num, pow) * option);

			if (option == 2 && i > 0) {
				for (int j = i - 1; j < i; j++) {
					score[j] *= 2;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			answer += score[i];
		}
		return answer;
	}
}
