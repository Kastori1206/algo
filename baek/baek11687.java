package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팩토리얼 0의 개수 
 * https://www.acmicpc.net/problem/11687
 */
public class baek11687 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());

		int answer = 0;
		int l = 0;
		int r = 1000000000;
		boolean flag = false;
		while (l <= r) {
			int mid = (l + r) / 2;
			// 5의 개수 찾기(2의 경우는 5보다 무조건 많기 때문)
			int cnt = 0;
			for (int i = 5; i <= mid; i *= 5) {
				cnt += mid / i;
			}

			if (cnt < M) {
				l = mid + 1;
			} else {
				if (cnt == M) {
					flag = true;
					answer = mid;
				}
				r = mid - 1;
			}
		}

		System.out.println(flag ? answer : -1);
	}
}
