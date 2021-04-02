package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 꿈틀꿈틀 호석 애벌레 - 효율성
 * https://www.acmicpc.net/problem/20181
 */
public class baek20181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		int[] arr = new int[N];
		long[] dp = new long[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long answer = 0, lmax = 0;
		long satisfaction = 0;
		int l = 0, r = 0;

		while (true) {
			if (satisfaction >= K) {
				lmax = (l==0 ? 0:Math.max(lmax, dp[l-1]));				
				dp[r - 1] = Math.max(dp[r - 1], lmax + satisfaction - K);
				satisfaction -= arr[l++];
			} else if (r == N) {
				break;
			} else {
				satisfaction += arr[r++];
			}
		}
		for (int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
