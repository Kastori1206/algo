package codeforces.div2.round704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A - Three swimmers
 * https://codeforces.com/contest/1492/problem/A
 */
public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			long p = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (p == a || p == b || p == c) {
				answer.append(0 + "\n");
			} else {
				long aa = (p / a + 1) * a;
				long bb = (p / b + 1) * b;
				long cc = (p / c + 1) * c;

				long temp = Math.min(aa - p, Math.min(bb - p, cc - p));
				answer.append(temp + "\n");
			}

		}
		System.out.println(answer.toString());

	}
}
