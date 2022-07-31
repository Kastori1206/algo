package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 9
 * https://www.acmicpc.net/problem/16195
 */
public class baek16915 {
    static final int MOD = 1000000009;
    static final int MAX = 1000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[MAX + 1][MAX + 1];

        dp[1][1] = dp[1][2] = dp[1][3] = dp[2][2] = dp[3][3] = 1;
        dp[2][3] = 2;

        for (int i = 4; i <= MAX; i++) {
            for (int j = 1; j <= MAX; j++) {
                dp[j][i] = (dp[j - 1][i - 3] + dp[j - 1][i - 2] + dp[j - 1][i - 1]) % MOD;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long answer = 0;
            for (int i = 1; i <= m; i++) {
                answer = (answer + dp[i][n]) % MOD;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
