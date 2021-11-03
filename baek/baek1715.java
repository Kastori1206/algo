package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기 
 * https://www.acmicpc.net/problem/1715
 */
public class baek1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(br.readLine()));
		}

		long answer = 0;
		while (pq.size() > 1) {
			long num1 = pq.poll();
			long num2 = pq.poll();

			answer += num1 + num2;
			pq.offer(answer);
		}
		System.out.println(answer);
	}
}
