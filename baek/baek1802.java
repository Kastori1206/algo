package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 종이 접기
 * https://www.acmicpc.net/problem/1802
 */
public class baek1802 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			char[] str = br.readLine().toCharArray();

			if (str.length == 1) {
				answer.append("YES\n");
				continue;
			}

			int len = str.length;
			int idx = len / 2;
			boolean flag = false;

			while (idx != 0) {
				int j = len - 1;
				for (int i = 0; i < idx; i++) {
					if (str[i] == str[j--]) {
						flag = true;
						break;
					}
				}

				if (flag) {
					break;
				}
				idx /= 2;
				len /= 2;
			}

			if (flag) {
				answer.append("NO\n");
			} else {
				answer.append("YES\n");
			}
		}
		System.out.println(answer.toString());
	}
}
