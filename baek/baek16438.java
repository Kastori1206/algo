package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 원숭이 스포츠
 * https://www.acmicpc.net/problem/16438
 */
public class baek16438 {
	static char[][] arr;
	static int N, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new char[7][111];
		dfs(1, N, 0);
		for (int i = 0; i <= cnt; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] == '\0') {
					arr[i][j] = j % 2 == 0 ? 'A' : 'B';
				}
				answer.append(arr[i][j]);
			}
			answer.append("\n");
		}

		while (cnt != 6) {
			for (int i = 0; i < N; i++) {
				if ((i & 1) == 1) {
					answer.append("A");
				} else {
					answer.append("B");
				}
			}
			answer.append("\n");
			cnt++;
		}

		System.out.println(answer.toString());
	}

	static void dfs(int s, int e, int d) {
		if (s >= e || d == 7) {
			return;
		}
		cnt = Math.max(cnt, d);
		int mid = (s + e) / 2;

		for (int i = s; i <= e; i++) {
			if (i <= mid) {
				arr[d][i] = 'A';
			} else {
				arr[d][i] = 'B';
			}
		}

		dfs(s, mid, d + 1);
		dfs(mid + 1, e, d + 1);
	}
}
