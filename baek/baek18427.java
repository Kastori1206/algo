package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 함께 블록 쌓기
 * https://www.acmicpc.net/problem/18427
 */
public class baek18427 {
    static final int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][H + 1];

        List<Integer>[] list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= H; j++) {
                for (int block : list[i]) {
                    if (j >= block) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - block]) % MOD;
                    }
                }
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
            }
        }
        System.out.println(dp[N][H]);
    }
}
