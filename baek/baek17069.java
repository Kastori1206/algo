package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 파이프 옮기기 2
 * https://www.acmicpc.net/problem/17069
 */
public class baek17069 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N][N] == 1) {
            System.out.println(0);
            return;
        }

        long[][][] dp = new long[N + 1][N + 1][3];
        dp[1][2][0] = 1;

        for (int r = 1; r <= N; r++) {
            for (int c = 3; c <= N; c++) {
                if (map[r][c] == 1) {
                    continue;
                }

                dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

                if (r == 1) {
                    continue;
                }
                dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

                if (map[r - 1][c] == 1 || map[r][c - 1] == 1) {
                    continue;
                }

                for (int k = 0; k < 3; k++) {
                    dp[r][c][2] += dp[r - 1][c - 1][k];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

}
