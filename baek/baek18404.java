package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 현명한 나이트
 * https://www.acmicpc.net/problem/18404
 */
public class baek18404 {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Node> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        q.offer(start);
        visited[start.r][start.c] = true;

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
                visited[nr][nc] = true;
                dist[nr][nc] = dist[cur.r][cur.c] + 1;
                q.offer(new Node(nr, nc));
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            answer.append(dist[r][c]).append(" ");
        }
        System.out.println(answer);
    }

    static boolean isIn(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }
}
