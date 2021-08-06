package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빌런 호석
 * https://www.acmicpc.net/problem/22251
 */
public class baek22251 {
	// 0~9까지 반전해야하는 수
	static final int[][] LED = { 
			{ 0, 4, 3, 3, 4, 3, 2, 3, 1, 2 }, 
			{ 4, 0, 5, 3, 2, 5, 6, 1, 5, 4 },
			{ 3, 5, 0, 2, 5, 4, 3, 4, 2, 3 },
			{ 3, 3, 2, 0, 3, 2, 3, 2, 2, 1 },
			{ 4, 2, 5, 3, 0, 3, 4, 3, 3, 2 },
			{ 3, 5, 4, 2, 3, 0, 1, 4, 2, 1 },
			{ 2, 6, 3, 3, 4, 1, 0, 5, 1, 2 },
			{ 3, 1, 4, 2, 3, 4, 5, 0, 4, 3 },
			{ 1, 5, 2, 2, 3, 2, 1, 4, 0, 1 },
			{ 2, 4, 3, 1, 2, 1, 2, 3, 1, 0 }, 
		};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (i == X) {
				continue;
			}
			int n1 = i;
			int n2 = X;

			int idx = K;
			int cnt = 0;
			while (true) {
				if (idx == 0) {
					break;
				}
				int pow = (int) Math.pow(10, idx - 1);
				int nn1 = n1 / pow;
				int nn2 = n2 / pow;

				cnt += LED[nn1][nn2];
				n1 %= pow;
				n2 %= pow;
				idx--;
			}

			if (cnt <= P) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
