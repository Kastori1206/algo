package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 배열 돌리기 4
 * https://www.acmicpc.net/problem/17406
 */
public class baek17406 {
	static int[][] A;
	static int N, M, K, answer;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = Integer.MAX_VALUE;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N][M];
		// 배열 입력
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 연산 입력
		int[][] command = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			command[i] = new int[] { r, c, s };
		}

		visited = new boolean[K];
		dfs(0, command, A);
		System.out.println(answer);
	}

	static void dfs(int n, int[][] command, int[][] arr) {
		if (n == K) {
			answer = Math.min(answer, getSum(arr));
			return;
		}
		for (int i = 0; i < command.length; i++) {
			if (visited[i]) {
				continue;
			}
			int[][] copyArr = copyArr(arr);

			int r = command[i][0];
			int c = command[i][1];
			int s = command[i][2];

			// 시작 row, col 끝 row, col
			int sr = r - s;
			int sc = c - s;
			int er = r + s;
			int ec = c + s;

			rotate(sr, sc, er, ec, copyArr);

			visited[i] = true;
			dfs(n + 1, command, copyArr);
			visited[i] = false;
		}
	}

	static void rotate(int sr, int sc, int er, int ec, int[][] arr) {
		// 밖에서 부터 안으로 한 횟수
		int cnt = 0;
		while (true) {
			// 횟수 마다 시작 row,col과 끝 row, col
			int srr = sr + cnt;
			int scc = sc + cnt;
			int err = er - cnt;
			int ecc = ec - cnt;

			if (srr >= err || scc >= ecc) {
				break;
			}

			int pre = arr[srr][ecc];
			for (int c = scc; c <= ecc; c++) {
				int temp = arr[srr][c];
				arr[srr][c] = pre;
				pre = temp;
			}

			for (int r = srr + 1; r <= err; r++) {
				int temp = arr[r][ecc];
				arr[r][ecc] = pre;
				pre = temp;
			}

			for (int c = ecc - 1; c >= scc; c--) {
				int temp = arr[err][c];
				arr[err][c] = pre;
				pre = temp;
			}

			for (int r = err - 1; r >= srr; r--) {
				int temp = arr[r][scc];
				arr[r][scc] = pre;
				pre = temp;
			}
			cnt++;
		}
	}

	private static int getSum(int[][] arr) {
		int res = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			int sum = 0;
			for (int c = 0; c < M; c++) {
				sum += arr[r][c];
			}
			res = Math.min(res, sum);
		}
		return res;
	}

	static int[][] copyArr(int[][] arr) {
		int[][] res = new int[arr.length][];
		for (int r = 0; r < arr.length; r++) {
			res[r] = arr[r].clone();
		}
		return res;
	}

	private static void print(int[][] arr) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}
}
