package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스티커
 * https://www.acmicpc.net/problem/9465
 */
public class baek9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N + 1][2];
            long[][] dp = new long[N + 1][3];
            for (int c = 0; c < 2; c++) {
                st = new StringTokenizer(br.readLine());
                for (int r = 1; r <= N; r++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
                dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + arr[i][0];
                dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + arr[i][1];
            }

            long answer = 0;
            for (int i = 1; i <= N; i++) {
                answer = max(max(answer, dp[i][0]), max(dp[i][1], dp[i][2]));
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }
}
