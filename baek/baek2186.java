package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 문자판
 * https://www.acmicpc.net/problem/2186
 */

public class baek2186 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, K;
    static int[][][] dp;
    static char[][] map;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }

        str = br.readLine();
        dp = new int[N][M][str.length()];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                Arrays.fill(dp[r][c], -1);
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == str.charAt(0)) {
                    answer += dfs(r, c, 0);
                }
            }
        }

        System.out.println(answer);
    }

    static public int dfs(int r, int c, int index) {
        if (index == str.length() - 1) {
            return dp[r][c][index] = 1;
        }
        if (dp[r][c][index] != -1) {
            return dp[r][c][index];
        }
        dp[r][c][index] = 0;
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] != str.charAt(index + 1)) {
                    continue;
                }
                dp[r][c][index] += dfs(nr, nc, index + 1);

            }
        }
        return dp[r][c][index];
    }

    static public boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
