package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 최소 힙
 * https://www.acmicpc.net/problem/1927
 */
public class baek1927 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val == 0) {
				if (pq.isEmpty()) {
					answer.append(0).append("\n");
				} else {
					answer.append(String.valueOf(pq.poll())).append("\n");
				}
			} else {
				pq.offer(val);
			}
		}

		System.out.println(answer.toString());
	}
}
