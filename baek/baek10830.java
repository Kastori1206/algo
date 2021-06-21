package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 행렬 제곱
 * https://www.acmicpc.net/problem/10830
 */
public class baek10830 {
	static final int MOD = 1000;
	static int N;
	static int[][] matrix;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		int[][] answer = pow(matrix, B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(answer[i][j]).append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] pow(int[][] A, long exp) {
		if (exp == 1L) {
			return A;
		}
		int[][] result = pow(A, exp / 2);

		result = mul(result, result);

		if (exp % 2 == 1L) {
			result = mul(result, matrix);
		}
		return result;
	}

	public static int[][] mul(int[][] A, int[][] B) {
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += A[i][k] * B[k][j];
					result[i][j] %= MOD;
				}
			}
		}
		return result;
	}

}
