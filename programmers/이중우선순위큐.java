package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "I 16", "D 1" })));
		System.out.println(
				Arrays.toString(solution(new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" })));
		System.out.println(Arrays.toString(solution(new String[] { "I 7", "I 5", "I -5", "D -1" })));
	}

	public static int[] solution(String[] operations) {
		int[] answer;
		StringTokenizer st;
		//최소값 우선순위큐
		PriorityQueue<Integer> min = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
		//최대값 우선순위큐
		PriorityQueue<Integer> max = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));

		for (int i = 0; i < operations.length; i++) {
			st = new StringTokenizer(operations[i]);
			String op = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			// 추가
			if (op.equals("I")) {
				min.offer(num);
				max.offer(num);
			} // 삭제
			else {
				if (num == 1) {
					if (!max.isEmpty()) {
						//최대값 우선순위큐에서 최대값을 빼고, 
						//최소값 우선순위큐에 최대값을 제거
						min.remove(max.poll());
					}
				} else {					
					if (!min.isEmpty()) {
						//최소값 우선순위큐에서 최소값을 빼고, 
						//최대값 우선순위큐에 최소값을 제거
						max.remove(min.poll());
					}
				}
			}
		}
		if (min.isEmpty()) {
			answer = new int[] { 0, 0 };
		} else {
			answer = new int[] { max.poll(), min.poll() };
		}
		return answer;
	}
}
