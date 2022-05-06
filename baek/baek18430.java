package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 무기 공학
 * https://www.acmicpc.net/problem/18430
 */
public class baek18430 {
    static int R, C, answer;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dr = {
            {1, 0},
            {-1, 0},
            {1, 0},
            {-1, 0}
    };
    static int[][] dc = {
            {0, -1},
            {0, -1},
            {0, 1},
            {0, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);

    }

    static void dfs(int r, int c, int sum) {
        if (c == C) {
            c = 0;
            r++;
        }
        if (r == R) {
            answer = Math.max(answer, sum);
            return;
        }
        if (!visited[r][c]) {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i][0];
                int nc = c + dc[i][1];
                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][c]) {
                    continue;
                }
                if (visited[r][nc]) {
                    continue;
                }

                visited[r][c] = visited[nr][c] = visited[r][nc] = true;
                int res = map[r][c] * 2 + map[nr][c] + map[r][nc] + sum;
                dfs(r, c + 1, res);
                visited[r][c] = visited[nr][c] = visited[r][nc] = false;

            }
        }
        dfs(r, c + 1, sum);

    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
