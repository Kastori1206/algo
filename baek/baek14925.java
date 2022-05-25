package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 목장 건설하기
 * https://www.acmicpc.net/problem/14925
 */
public class baek14925 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[M + 1][N + 1];
        int[][] dp = new int[M + 1][N + 1];

        for (int r = 1; r <= M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int r = 1; r <= M; r++) {
            for (int c = 1; c <= N; c++) {
                if (map[r][c] > 0) {
                    continue;
                }
                dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                answer = Math.max(answer, dp[r][c]);
            }
        }
        System.out.println(answer);
    }
}
