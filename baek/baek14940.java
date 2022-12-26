package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 쉬운 최단거리
 * https://www.acmicpc.net/problem/14940
 */
public class baek14940 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        Node end = null;
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    end = new Node(r, c);
                }
            }
        }

        int[][] answer = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(end);
        visited[end.r][end.c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    continue;
                }

                q.offer(new Node(nr, nc));
                visited[nr][nc] = true;
                answer[nr][nc] = answer[cur.r][cur.c] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (answer[r][c] == 0 && map[r][c] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(answer[r][c]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
