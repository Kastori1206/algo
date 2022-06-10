package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1, 2, 3 더하기 8
 * https://www.acmicpc.net/problem/15993
 */
public class baek15993 {
    static final int MOD = 1000000009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[100000 + 1][2];
        dp[1][0] = dp[2][0] = dp[2][1] = 1;
        dp[3][0] = dp[3][1] = 2;

        for (int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}
