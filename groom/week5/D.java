package groom.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
    static final int MOD = 100000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[1000 + 1][200 + 1];

        for (int a = 0; a <= K; a++) {
            for (int b = 0; b <= N + M; b++) {
                dp[a][b] %= MOD;
                if (b == 0 || b == N + M) {
                    dp[a][b] = 1;
                }
                if (0 < b - 1 && b - 1 < N + M) {
                    dp[a + 1][b - 1] += dp[a][b];
                }
                if (0 < b && b < N + M) {
                    dp[a + 1][b] += dp[a][b];
                }
                if (b + 1 < N + M) {
                    dp[a + 1][b + 1] += dp[a][b];
                }
            }
        }
        System.out.println(dp[K][N]);
    }
}
