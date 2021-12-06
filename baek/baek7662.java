package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 이중 우선순위 큐
 * https://www.acmicpc.net/problem/7662
 */
public class baek7662 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> ts = new TreeMap<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());

				if (cmd.equals("I")) {
					ts.put(n, ts.getOrDefault(n, 0) + 1);
				} else {
					if (ts.isEmpty()) {
						continue;
					}
					int num;
					if (n == 1) {
						num = ts.lastKey();
					} else {
						num = ts.firstKey();
					}

					if (ts.put(num, ts.get(num) - 1) == 1) {
						ts.remove(num);
					}
				}
			}

			if (ts.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(ts.lastKey() + " " + ts.firstKey());
			}
		}
	}
}
