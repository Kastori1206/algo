package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 빙산
 * https://www.acmicpc.net/problem/2573
 */
public class baek2573 {
    static class Ice {
        int r, c;

        public Ice(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int R, C, answer;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        int area = 0;
        while ((area = check()) < 2) {
            if (area == 0) {
                answer = 0;
                break;
            }
            answer++;
            int[][] temp = new int[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] <= 0) {
                        continue;
                    }
                    temp[r][c] = next(r, c);
                }
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    map[r][c] -= temp[r][c];
                }
            }
        }
        System.out.println(answer);
    }

    private static int check() {
        visited = new boolean[R][C];

        int res = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) {
                    continue;
                }
                if (map[r][c] <= 0) {
                    continue;
                }
                getArea(r, c);
                res++;
            }
        }
        return res;
    }

    private static void getArea(int r, int c) {
        Queue<Ice> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Ice(r, c));
        while (!q.isEmpty()) {
            Ice ice = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = ice.r + dr[d];
                int nc = ice.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] <= 0) {
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new Ice(nr, nc));
            }
        }

    }

    public static int next(int r, int c) {
        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (map[nr][nc] > 0) {
                continue;
            }
            if (map[r][c] <= 0) {
                continue;
            }
            res++;
        }
        return res;
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
