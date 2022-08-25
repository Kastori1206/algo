package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 아기 상어2
 * https://www.acmicpc.net/problem/17086
 */
public class baek17086 {
    static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) {
                    continue;
                }
                answer = Math.max(answer, bfs(new Node(r, c, 0)));
            }
        }
        System.out.println(answer);
    }

    static int bfs(Node start) {
        visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 1) {
                    return cur.d + 1;
                }
                visited[nr][nc] = true;
                q.offer(new Node(nr, nc, cur.d + 1));
            }
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
