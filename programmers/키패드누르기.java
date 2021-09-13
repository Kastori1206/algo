package programmers;

import java.util.HashMap;
import java.util.Map;
/**
 * 키패드 누르기 
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class 키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		Map<Integer, int[]> map = new HashMap<>();

		int n = 1;
		map.put(0, new int[] { 3, 1 });
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				map.put(n++, new int[] { r, c });
			}
		}

		int[] left = { 3, 0 };
		int[] right = { 3, 2 };
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (number == 1 || number == 4 || number == 7) {
				answer.append("L");
				left = map.get(number);
			} else if (number == 3 || number == 6 || number == 9) {
				answer.append("R");
				right = map.get(number);
			} else {
				int[] next = map.get(number);
				int l = getDist(left, next);
				int r = getDist(right, next);
				if (l > r) {
					answer.append("R");
					right = next;
				} else if (l < r) {
					answer.append("L");
					left = next;
				} else {
					if (hand.equals("right")) {
						right = next;
						answer.append("R");
					} else {
						left = next;
						answer.append("L");
					}
				}
			}
		}

		return answer.toString();
	}

	public static int getDist(int[] cur, int[] next) {
		return (int) (Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]));
	}
}
