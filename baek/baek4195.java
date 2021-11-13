package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 친구 네트워크 
 * https://www.acmicpc.net/problem/4195
 */
public class baek4195 {
	static int[] p;
	static int[] answer;
	static int[] size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int F = Integer.parseInt(br.readLine());
			p = new int[F * 2];
			answer = new int[F * 2];

			for (int i = 0; i < F * 2; i++) {
				p[i] = i;
			}

			// 친구 관계 1로 초기화
			Arrays.fill(answer, 1);
			Map<String, Integer> map = new HashMap<String, Integer>();
			int idx = 0;
			for (int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();

				map.putIfAbsent(f1, idx++);
				map.putIfAbsent(f2, idx++);

				int a = map.get(f1);
				int b = map.get(f2);

				sb.append(union(a, b)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);

	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b) {
				p[b] = a;
				answer[a] += answer[b];
				return answer[a];
			} else {
				p[a] = b;
				answer[b] += answer[a];
				return answer[b];
			}
		}
		return answer[a];
	}
}
