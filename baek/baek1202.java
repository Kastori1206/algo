package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 보석 도둑 
 * https://www.acmicpc.net/problem/1202
 */
public class baek1202 {
	static class Jewel implements Comparable<Jewel> {
		int m, v;

		public Jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Jewel [m=" + m + ", v=" + v + "]";
		}

		@Override
		public int compareTo(Jewel o) {
			if (m == o.m) {
				return -Integer.compare(v, o.v);
			}
			return Integer.compare(m, o.m);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 무게가 낮고 가격이 높은 순으로 정렬
		PriorityQueue<Jewel> jewels = new PriorityQueue<>();

		List<Integer> bags = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels.offer(new Jewel(m, v));
		}

		for (int i = 0; i < K; i++) {
			int C = Integer.parseInt(br.readLine());
			bags.add(C);
		}

		// 무게가 낮은 순으로 정렬
		Collections.sort(bags);

		long answer = 0;
		// 가격이 높은 것 부터
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

		for (int i = 0; i < K; i++) {
			int m = bags.get(i);
			
			//보석이 비어있지 않고 가방 무게보다 작은 보석 pq에 추가
			while (!jewels.isEmpty() && jewels.peek().m <= m) {
				pq.offer(jewels.poll().v);
			}

			if (!pq.isEmpty()) {
				answer += pq.poll();
			}
		}
		System.out.println(answer);
	}
}
