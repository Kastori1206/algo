package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 물통
 * https://www.acmicpc.net/problem/2251
 */
public class baek2251 {
	static class Water {
		int a, b, c;

		public Water(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "water [a=" + a + ", b=" + b + ", c=" + c + "]";
		}

	}

	static boolean[][][] visited;
	static List<Integer> answer = new ArrayList<>();
	static int A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[A + 1][B + 1][C + 1];

		bfs(new Water(0, 0, C));

		Collections.sort(answer);
		for (Integer n : answer) {
			System.out.print(n + " ");

		}
	}

	private static void bfs(Water water) {
		Queue<Water> q = new LinkedList<>();
		q.add(water);
		while (!q.isEmpty()) {
			Water w = q.poll();
			int a = w.a;
			int b = w.b;
			int c = w.c;

			if (visited[a][b][c]) {
				continue;
			}
			if (w.a == 0) {
				answer.add(w.c);
			}
			visited[a][b][c] = true;
			// 물통 A로 물 이동
			if (a + b <= A) {
				q.add(new Water(a + b, 0, c));
			} else {
				q.add(new Water(A, a + b - A, c));
			}

			if (a + c <= A) {
				q.add(new Water(a + c, b, 0));
			} else {
				q.add(new Water(A, b, a + c - A));
			}

			// 물통 B로 물 이동
			if (b + a <= B) {
				q.add(new Water(0, a + b, c));
			} else {
				q.add(new Water(a + b - B, B, c));
			}

			if (b + c <= B) {
				q.add(new Water(a, b + c, 0));
			} else {
				q.add(new Water(a, B, b + c - B));
			}

			// 물통 C로 물 이동

			if (c + a <= C) {
				q.add(new Water(0, b, c + a));
			} else {
				q.add(new Water(c + a - C, b, C));
			}

			if (c + b <= C) {
				q.add(new Water(a, 0, c + b));
			} else {
				q.add(new Water(a, c + b - C, C));
			}
		}

	}

}
