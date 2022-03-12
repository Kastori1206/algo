package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Game Addiction
 * https://www.acmicpc.net/problem/20152
 */
public class baek20152 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[][] dp = new long[31][31];

        for (int i = 0; i < 31; i++) {
            dp[0][i] = 1;
        }

        for (int r = 1; r < 31; r++) {
            for (int c = r; c < 31; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }

        int v = Math.abs(h - n);
        System.out.println(dp[v][v]);
    }
}
