package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * K진 트리 
 * https://www.acmicpc.net/problem/11812
 */
public class baek11812 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			long answer = 0;

			if (K == 1) {
				answer = Math.abs(a - b);
			} else {
				while (a != b) {
					if (a < b) {
						b = (b - 2) / K + 1;
					} else {
						a = (a - 2) / K + 1;
					}

					answer++;
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());

	}
}
