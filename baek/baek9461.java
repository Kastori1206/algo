package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 파도반 수열
 * https://www.acmicpc.net/problem/9461
 */
public class baek9461 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		long[] dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		dp[6] = 3;
		dp[7] = 4;
		dp[8] = 5;
		dp[9] = 7;
		dp[10] = 9;
		
		for (int i = 11; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(dp[N] + "\n");
		}

		bw.flush();
		bw.close();
	}
}
