package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비숍
 * https://www.acmicpc.net/problem/1799
 */
public class baek1799 {
    static int N;
    static int[] answer;
    static boolean[] visited;
    static int[][] map, colors;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {-1, 1, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        colors = new int[N][N];
        answer = new int[2];
        visited = new boolean[N * N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (r % 2 == 0){
                    if (c % 2 == 0) {
                        colors[r][c] = 1;
                    }
                } else{
                    if (c % 2 != 0) {
                        colors[r][c] = 1;
                    }
                }
            }
        }

        dfs(-1, 0, 1);
        dfs(-1, 0, 0);
        System.out.println(answer[0] + answer[1]);
    }

    static void dfs(int v, int cnt, int color) {
        answer[color] = Math.max(answer[color], cnt);

        for (int i = v + 1; i < N * N; i++) {
            int r = i / N;
            int c = i % N;

            if (colors[r][c] != color) {
                continue;
            }

            if (map[r][c] != 1) {
                continue;
            }
            if (!check(r, c)) {
                continue;
            }
            visited[i] = true;
            dfs(i, cnt + 1, color);
        }
        if (v == -1) {
            return;
        }
        visited[v] = false;
    }

    private static boolean check(int r, int c) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            int v = nr * N + nc;

            for (int i = 1; i < N; i++) {
                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[v]) {
                    return false;
                }
                nr += dr[d];
                nc += dc[d];
                v = nr * N + nc;
            }
        }

        return true;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
