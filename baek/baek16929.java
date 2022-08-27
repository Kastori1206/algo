package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Two Dots
 * https://www.acmicpc.net/problem/16929
 */
public class baek16929 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }


        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) {
                    continue;
                }

                dfs(r, c, 1, -1, -1, map[r][c]);
                if (flag) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static void dfs(int r, int c, int br, int bc, int cnt, char color) {
        if (visited[r][c] && cnt >= 4) {
            flag = true;
            return;
        }
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc)) {
                continue;
            }

            if (map[nr][nc] != color) {
                continue;
            }
            if (nr == br && nc == bc) {
                continue;
            }
            dfs(nr, nc, r, c, cnt + 1, color);
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
