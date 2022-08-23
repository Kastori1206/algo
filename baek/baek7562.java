package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 * https://www.acmicpc.net/problem/7562
 */
public class baek7562 {
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;
    static int[][] dist;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], -1);

            }
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            sb.append(bfs(sr, sc, er, ec)).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs(int sr, int sc, int er, int ec) {
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == er && cur[1] == ec) {
                res = dist[er][ec];
                break;
            }
            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (dist[nr][nc] != -1) {
                    continue;
                }

                q.offer(new int[]{nr, nc});
                dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
            }
        }

        return res;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
