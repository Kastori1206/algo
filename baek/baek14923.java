package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로 탈출
 * https://www.acmicpc.net/problem/14923
 */
public class baek14923 {
    static class Point {
        int r;
        int c;
        int t;
        int flag;

        public Point(int r, int c, int t, int flag) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", t=" + t +
                    ", flag=" + flag +
                    '}';
        }
    }

    static int R, C;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C][2];
        st = new StringTokenizer(br.readLine());
        Point start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, 0);

        st = new StringTokenizer(br.readLine());
        Point end = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, 0);

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.r == end.r && p.c == end.c) {
                System.out.println(p.t);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int flag = p.flag;

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc][p.flag]) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    if (p.flag == 1) {
                        continue;
                    }
                    flag = 1;
                }
                visited[nr][nc][flag] = true;
                q.offer(new Point(nr, nc, p.t + 1, flag));
            }
        }
        System.out.println(-1);
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
