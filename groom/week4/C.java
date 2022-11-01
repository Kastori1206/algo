package groom.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 거리두기
 */
public class C {
    static final int MOD = 100000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] % MOD + dp[i - 1][1] % MOD + dp[i - 1][2] % MOD + dp[i - 1][3] % MOD + dp[i - 1][4] % MOD) % MOD;
            dp[i][1] = (dp[i - 1][0] % MOD + dp[i - 1][2] % MOD + dp[i - 1][3] % MOD) % MOD;
            dp[i][2] = (dp[i - 1][0] % MOD + dp[i - 1][1] % MOD + dp[i - 1][3] % MOD + dp[i - 1][4] % MOD) % MOD;
            dp[i][3] = (dp[i - 1][0] % MOD + dp[i - 1][1] % MOD + dp[i - 1][2] % MOD) % MOD;
            dp[i][4] = (dp[i - 1][0] % MOD + dp[i - 1][2] % MOD) % MOD;
        }

        long answer = 0;
        for (int i = 0; i < 5; i++) {
            answer = (answer%MOD + dp[N][i]%MOD) % MOD;
        }
        System.out.println(answer);
    }
}
