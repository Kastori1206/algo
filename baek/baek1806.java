package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부분합
 * https://www.acmicpc.net/problem/1806
 */
public class baek1806 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());

		long[] arr = new long[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long ans = Long.MAX_VALUE;
		int left = 0, right = 0;
		long sum = 0;
		while (left <= N && right <= N) {
			if (sum >= S) {
				ans = Math.min(ans, right - left);
			} 
			if (sum < S) {
				sum += arr[right++];
			} else {
				sum -= arr[left++];
			}
		}

		System.out.println(ans == Long.MAX_VALUE ? 0 : ans);
	}
}