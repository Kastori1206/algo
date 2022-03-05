package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출근 경로
 * https://www.acmicpc.net/problem/5569
 */
public class baek5569 {
    static final int MOD = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[h + 1][w + 1][4];
        for (int r = 1; r <= h; r++) {
            dp[r][1][0] = 1;
        }
        for (int c = 1; c <= w; c++) {
            dp[1][c][2] = 1;
        }

        for (int r = 2; r <= h; r++) {
            for (int c = 2; c <= w; c++) {
                dp[r][c][0] = (dp[r - 1][c][1] + dp[r - 1][c][0]) % MOD;
                dp[r][c][1] = dp[r - 1][c][2];

                dp[r][c][2] = (dp[r][c - 1][3] + dp[r][c - 1][2]) % MOD;
                dp[r][c][3] = dp[r][c - 1][0];
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += dp[h][w][i];
        }
        System.out.println(answer % MOD);
    }
}
