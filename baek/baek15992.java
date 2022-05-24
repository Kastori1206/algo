package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1, 2, 3 더하기 7
 * https://www.acmicpc.net/problem/15992
 */
public class baek15992 {
    static final int MOD = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[1001][1001];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
        dp[3][2] = 2;

        for (int i = 4; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 2][j - 1]) % MOD + dp[i - 3][j - 1]) % MOD;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[N][M]).append("\n");
        }
        System.out.println(sb);
    }
}
