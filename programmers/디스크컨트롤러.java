package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 0, 3 }, { 1, 9 }, { 2, 6 } }));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int end = 0; // 수행되고난 직후 시간
		int index = 0;// 배열 인덱스
		int len = jobs.length;

		// 시작시간으로 정렬
		Arrays.sort(jobs, (x, y) -> Integer.compare(x[0], y[0]));

		// 시작점이 같다면 작업이 먼저 끝나는 것 부터 처리
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));

		while (index < len || !pq.isEmpty()) {
			// 시작시간이 작업이 이전작업이 끝난시간보다 작으면 큐에 넣음
			while (index < len && jobs[index][0] <= end) {
				pq.offer(jobs[index++]);
			}

			if (pq.isEmpty()) {
				end = jobs[index][0];
			} else {
				int[] job = pq.poll();
				answer += end + job[1] - job[0];
				end += job[1];
			}
		}

		return answer / len;
	}
}
