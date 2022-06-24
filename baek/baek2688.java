package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 줄어들지 않아
 * https://www.acmicpc.net/problem/2688
 */
public class baek2688 {
    static int MAX = 64;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[MAX + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= MAX; i++) {
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j] + sum;
                sum += dp[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long answer = 0;
            for (int i = 0; i <= 9; i++) {
                answer += dp[n][i];
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
