package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬 분할
 * https://www.acmicpc.net/problem/1509
 */
public class baek1509 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        str = " " + str;
        int[] dp = new int[N + 1];
        boolean[][] palin = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            palin[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                palin[i][i + 1] = true;
            }
        }

        for (int j = 2; j < N; j++) {
            for (int i = 1; i <= N - j; i++) {
                int k = i + j;
                if (str.charAt(i) == str.charAt(k) && palin[i + 1][k - 1]) {
                    palin[i][k] = true;
                }
            }
        }

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = 987654321;
            for (int j = 1; j <= i; j++) {
                if (palin[j][i]) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}

