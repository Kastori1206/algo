package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 암호코드
 * https://www.acmicpc.net/problem/2011
 */
public class baek2011 {
    static final int MOD = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int N = input.length();

        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = input.charAt(i - 1) - '0';
        }
        dp[0] = 1;
        for (int i = 1; i <=N; i++) {
            if (arr[i] != 0) {
                dp[i] = (dp[i - 1] + dp[i]) % MOD;
            }

            int n = arr[i] + arr[i - 1] * 10;

            if (10 <= n && n <= 26) {
                dp[i] = (dp[i - 2] + dp[i]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
