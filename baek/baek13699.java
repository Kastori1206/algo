package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 점화식
 * https://www.acmicpc.net/problem/13699
 */
public class baek13699 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] t = new long[N + 1];
		t[0] = 1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= i - 1; j++) {
				t[i] += t[j] * t[i - 1 - j];
			}
		}

		System.out.println(t[N]);
	}
}
