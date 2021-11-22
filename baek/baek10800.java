package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 컬러볼
 * https://www.acmicpc.net/problem/10800
 */
public class baek10800 {
	static class Ball implements Comparable<Ball> {
		int idx, color, size;

		protected Ball(int idx, int color, int size) {
			super();
			this.idx = idx;
			this.color = color;
			this.size = size;
		}

		@Override
		public int compareTo(Ball o) {
			return Integer.compare(this.size, o.size);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Ball> balls = new ArrayList<>();

		for (int idx = 0; idx < N; idx++) {
			st = new StringTokenizer(br.readLine());
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			balls.add(new Ball(idx, color, size));
		}

		Collections.sort(balls);

		int[] answer = new int[N];
		int[] colors = new int[N + 1];
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			Ball cur = balls.get(i);
			while (balls.get(idx).size < cur.size) {
				sum += balls.get(idx).size;
				colors[balls.get(idx).color] += balls.get(idx).size;
				idx++;
			}
			answer[cur.idx] = sum - colors[cur.color];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
