package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막길
 * https://www.acmicpc.net/problem/1520
 */
public class baek1520 {
    //상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int R, C;
    static int[][] dp, map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dp = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                //초기화 -1 방문하지않음
                dp[r][c] = -1;
            }
        }
        System.out.println(dfs(R-1, C-1));
    }

    public static int dfs(int r, int c) {
        //출발점에 도착했으면
        if (r == 0 && c == 0) {
            return 1;
        }
        //방문하지 않았으면
        if (dp[r][c] == -1) {
            dp[r][c] = 0;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[r][c] >= map[nr][nc]) {
                    continue;
                }
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}