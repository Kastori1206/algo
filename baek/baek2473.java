package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 세 용액
 * https://www.acmicpc.net/problem/2473
 */
public class baek2473 {
	static long[] answer;
	static long zero;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		zero = Long.MAX_VALUE;
		Arrays.sort(arr);

		answer = new long[3];

		for (int i = 0; i < N - 2; i++) {
			search(arr, i);
		}
		Arrays.sort(answer);
		System.out.printf("%d %d %d",answer[0],answer[1],answer[2]);
	}

	private static void search(long[] arr, int idx) {
		int left = idx + 1;
		int right = arr.length - 1;

		while (left < right) {
			long sum = arr[idx] + arr[left] + arr[right];

			if (Math.abs(sum) < zero) {
				answer[0] = arr[idx];
				answer[1] = arr[left];
				answer[2] = arr[right];

				zero = Math.abs(sum);
			}

			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
	}
}
