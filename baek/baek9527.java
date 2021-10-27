package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1의 개수 세기 
 * https://www.acmicpc.net/problem/9527
 */
public class baek9527 {
	static long[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		dp = new long[55]; // 10^16의 비트길이는 54(0부터)
		dp[0] = 1;
		for (int i = 1; i < 55; i++) {
			System.out.println(1L << i);
			dp[i] = dp[i - 1] * 2 + (1L << i);
		}
		System.out.println(dfs(B) - dfs(A - 1));

	}

	static long dfs(long x) {
		long answer = x & 1;
		for (int i = 54; i > 0; i--) {
			if ((x & (1L << i)) > 0L) {// x의 i번째 비트가 1이면
				answer += dp[i - 1] + (x - (1L << i) + 1);
				x -= (1L << i);
			}
		}
		return answer;
	}
}
