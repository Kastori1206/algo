package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개똥벌레
 * https://www.acmicpc.net/problem/3020
 */
public class baek3020 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] top = new int[H + 1];
		int[] bottom = new int[H + 1];

		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				bottom[idx]++;
			} else {
				top[H + 1 - idx]++;
			}
		}

		for (int i = 1; i <= H; i++) {
			top[i] += top[i - 1];
			bottom[H - i] += bottom[H + 1 - i];
		}

		int min = N;
		int cnt = 0;

		for (int i = 1; i <= H; i++) {
			int temp = top[i] + bottom[i];
			if (min > temp) {
				min = temp;
				cnt = 1;
			} else if (min == temp) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);
	}
}
