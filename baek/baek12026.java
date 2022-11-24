package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 거리
 * https://www.acmicpc.net/problem/12026
 */
public class baek12026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();
        int[] dp = new int[N];

        Arrays.fill(dp, 987654321);

        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            char block = str[i];

            if (block == 'B') {
                for (int j = i + 1; j < N; j++) {
                    char nextBlock = str[j];
                    if (nextBlock == 'O') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            } else if (block == 'O') {
                for (int j = i + 1; j < N; j++) {
                    char nextBlock = str[j];
                    if (nextBlock == 'J') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            } else {
                for (int j = i + 1; j < N; j++) {
                    char nextBlock = str[j];
                    if (nextBlock == 'B') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            }
        }

        System.out.println(dp[N - 1] == 987654321 ? -1 : dp[N - 1]);
    }
}
