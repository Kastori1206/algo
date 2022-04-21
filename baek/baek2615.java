package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오목
 * https://www.acmicpc.net/problem/2615
 */
public class baek2615 {
    static int[][] map;
    static int max = 19;
    static int[][][] memo;
    static int[] dr = {1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;


        map = new int[max + 2][max + 2];
        memo = new int[max + 2][max + 2][4];
        for (int r = 1; r <= max; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= max; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int c = 1; c <= max; c++) {
            for (int r = 1; r <= max; r++) {
                int color = map[r][c];
                if (color == 0) {
                    continue;
                }
                for (int d = 0; d < 4; d++) {
                    if (memo[r][c][d] == 0 && calc(r, c, d, color) == 5) {
                        System.out.println(color);
                        System.out.println(r + " " + c);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static int calc(int r, int c, int d, int color) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if (map[nr][nc] == color) {
            return memo[nr][nc][d] = calc(nr, nc, d, color) + 1;
        }
        return 1;
    }
}
