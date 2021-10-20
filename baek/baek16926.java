package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 1 
 * https://www.acmicpc.net/problem/16926
 */
public class baek16926 {
	static int N, M, R;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			rotate();
		}

		print();

	}

	static void rotate() {
		int cnt = 0;

		while (cnt < Math.min(N / 2, M / 2)) {
			int sr = 0 + cnt;
			int sc = 0 + cnt;
			int er = N - 1 - cnt;
			int ec = M - 1 - cnt;

			int pre = 0;
			for (int r = sr; r <= er; r++) {
				int temp = arr[r][sc];
				arr[r][sc] = pre;
				pre = temp;
			}

			for (int c = sc + 1; c <= ec; c++) {
				int temp = arr[er][c];
				arr[er][c] = pre;
				pre = temp;
			}

			for (int r = er - 1; r >= sr; r--) {
				int temp = arr[r][ec];
				arr[r][ec] = pre;
				pre = temp;
			}

			for (int c = ec - 1; c >= sc; c--) {
				int temp = arr[sr][c];
				arr[sr][c] = pre;
				pre = temp;
			}
			cnt++;
		}
	}

	static void print() {
		StringBuilder answer = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				answer.append(arr[r][c] + " ");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
	}
}
