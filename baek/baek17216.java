package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가장 큰 감소 부분 수열
 * https://www.acmicpc.net/problem/17216
 */
public class baek17216 {
	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
			for (int k = 0; k < i; k++) {
				if (arr[k] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[k] + arr[i]);
				}
			}
		}
		long answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}

		System.out.println(answer);
	}

}
