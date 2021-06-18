package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * 돌 그룹
 * https://www.acmicpc.net/problem/12886
 */
public class baek12886 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] stones = new int[3];
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			stones[i] = Integer.parseInt(st.nextToken());
			sum += stones[i];
		}

		if (sum % 3 != 0) {
			System.out.println(0);
			return;
		}

		boolean flag = false;
		Set<String> visited = new HashSet<>();
		Queue<int[]> q = new LinkedList<>();
		q.add(stones);

		visited.add(String.valueOf(stones[0]) + String.valueOf(stones[1]) + String.valueOf(stones[2]));
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int a = temp[0];
			int b = temp[1];
			int c = temp[2];

			if (a == b && b == c && c == a) {
				flag = true;
				break;
			}

			int aa, bb, cc;

			if (a > b) {
				aa = a - b;
				bb = b + b;
				cc = c;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}

			}
			if (b > a) {
				aa = a + a;
				bb = b - a;
				cc = c;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}
			}
			if (a > c) {
				aa = a - c;
				cc = c + c;
				bb = b;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}
			}
			if (c > a) {
				aa = a + a;
				cc = c - a;
				bb = b;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}

			}
			if (b > c) {
				aa = a;
				bb = b - c;
				cc = c + c;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}

			}
			if (c > b) {
				aa = a;
				bb = b + b;
				cc = c - b;
				String s = String.valueOf(aa) + String.valueOf(bb) + String.valueOf(cc);
				if (!visited.contains(s)) {
					visited.add(s);
					q.offer(new int[] { aa, bb, cc });
				}
			}
		}
		System.out.println(flag ? 1 : 0);

	}
}
