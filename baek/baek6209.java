package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제자리 멀리뛰기 
 * https://www.acmicpc.net/problem/6209
 */
public class baek6209 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 2];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[N] = 0;
		arr[N + 1] = D;
		Arrays.sort(arr);

		int l = 0, r = D, answer = 0;
		while (l <= r) {
			int mid = (l + r) / 2;
			int sum = 0;
			int cur = 0;
			for (int i = 1; i < N + 2; i++) {
				if (arr[i] - arr[cur] < mid) {
					sum++;
				} else
					cur = i;
			}
			if (sum > M) {
				r = mid - 1;
			} else {
				answer = mid;
				l = mid + 1;
			}
		}
		System.out.println(answer);
	}
}
