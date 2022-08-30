package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 육각 보드
 * https://www.acmicpc.net/problem/12946
 */
public class baek12946 {
    static int[] dr = {0, -1, -1, 0, 1, 1};
    static int[] dc = {-1, 0, 1, 1, 0, -1};
    static int N, answer;
    static int[][] colors;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        colors = new int[N][N];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
            Arrays.fill(colors[r], -1);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 'X' && colors[r][c] == -1) {
                    dfs(r, c, 0);
                }
            }
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c, int color) {
        colors[r][c] = color;
        answer = Math.max(answer, 1);
        for (int d = 0; d < 6; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!isIn(nr, nc)) {
                continue;
            }
            if (map[nr][nc] != 'X') {
                continue;
            }
            if (colors[nr][nc] == -1) {
                dfs(nr, nc, 1 - color);
            }
            answer = Math.max(answer, 2);
            if (colors[nr][nc] == color) {
                answer = Math.max(answer, 3);
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
