package codeforces.global.round13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * B - Minimal Cost
 */
public class B {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			int[] map = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			boolean isAnswer = false;
			boolean flag = false;
			for (int i = 1; i <= n; i++) {
				map[i] = Integer.parseInt(st.nextToken());
				if (i > 1) {
					int diff = Math.abs(map[i] - map[i - 1]);
					if (diff > 1) {
						isAnswer = true;
						System.out.println(0);
						break;
					}
					if (diff != 0) {
						flag = true;
					}
				}
			}
			if (!isAnswer) {
				if (flag) {
					System.out.println(Math.min(u, v));
				} else {
					System.out.println(Math.min(2 * v, u + v));
				}
			}
		}
	}
}