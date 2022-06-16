package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baek14852 {
    /**
     * 타일 채우기 3
     * https://www.acmicpc.net/problem/14852
     */
    static int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[1000001][2];

        dp[1][0] = 2;
        dp[2][0] = 7;
        dp[2][1] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i][1] = (dp[i - 3][0] + dp[i - 1][1]) % MOD;
            dp[i][0] = (dp[i][1] * 2 + dp[i - 1][0] * 2 + dp[i - 2][0] * 3) % MOD;
        }
        System.out.println(dp[N][0]);
    }
}
