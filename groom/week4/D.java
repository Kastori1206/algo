package groom.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 주차구역나누기
 */
public class D {
    static final int MOD = 100000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[200000 + 1];

        dp[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((2L * (i - 1) + 1) * dp[i - 1] + dp[i - 2]) % MOD;
        }
        System.out.println(dp[N] % MOD);


    }
}
