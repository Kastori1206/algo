package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 휴게소 세우기
 * https://www.acmicpc.net/problem/1477
 */
public class baek1477 {
	static int[] arr;
	static int N, M, L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N + 2];
		arr[0] = 0;
		arr[N + 1] = L;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		System.out.println(binarySearch());
	}

	static int binarySearch() {
		int l = 1, r = L;

		while (l <= r) {
			int mid = (l + r) / 2;
			int cnt = 0;
			for (int i = 1; i < N + 2; i++) {
				cnt += (arr[i] - arr[i - 1] - 1) / mid;
			}
			if (cnt > M) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
}
