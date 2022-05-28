package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프왕 쩰리 (Large)
 * https://www.acmicpc.net/problem/16174
 */
public class baek16174 {
    static int N;
    static int[][] map;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println("Hing");
    }

    static void dfs(int r, int c) {
        int move = map[r][c];
        if (move == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d] * move;
            int nc = c + dc[d] * move;

            if (!isIn(nr, nc)) {
                continue;
            }
            if (visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
