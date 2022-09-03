package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NM과 K(1)
 * https://www.acmicpc.net/problem/18290
 */
public class baek18290 {
    static int N, M, K, answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        answer = Integer.MIN_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, 0, 0, 0);
        System.out.println(answer);
    }

    static void go(int r, int c, int cnt, int sum) {
        if (cnt == K) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = r; i < N; i++) {
            for (int j = (i == r ? c : 0); j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (check(i, j)) {
                    visited[i][j] = true;
                    go(i, j, cnt + 1, sum + map[i][j]);
                    visited[i][j] = false;
                }
            }
        }
    }

    private static boolean check(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (visited[nr][nc]) {
                return false;
            }

        }
        return true;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
