package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 로또
 * https://www.acmicpc.net/problem/2758
 */
public class baek2758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[][] dp = new long[N + 1][M + 1];

            Arrays.fill(dp[0], 1);

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
                }
            }
            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }

}
