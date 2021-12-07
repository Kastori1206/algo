package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 데이터 체커
 * https://www.acmicpc.net/problem/22942
 */
public class baek22942 {
	static class Circle implements Comparable<Circle> {

		int start, end;

		protected Circle(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Circle o) {
			if (start == o.start) {
				return Integer.compare(end, o.end);
			}
			return Integer.compare(start, o.start);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Circle> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			pq.offer(new Circle(x - r, x + r));
		}

		boolean flag = true;
		Circle prev = new Circle(-Integer.MIN_VALUE, -Integer.MIN_VALUE);
		while (!pq.isEmpty()) {
			Circle cur = pq.poll();
			if (prev.end >= cur.start && prev.end <= cur.end) {
				flag = false;
				break;
			}
			prev = cur;
		}

		System.out.println(flag ? "YES" : "NO");
	}
}
