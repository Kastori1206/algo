package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1249. [S/W 문제해결 응용] 4일차 - 보급로
 */
public class swea1249 {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(dist, o.dist);
        }

    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                String input = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = input.charAt(c) - '0';
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));
            visited[0][0] = true;

            int answer = 0;
            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.r == N - 1 && cur.c == N - 1) {
                    answer = cur.dist;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isIn(nr, nc, N)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }

                    pq.offer(new Node(nr, nc, cur.dist + map[nr][nc]));
                    visited[nr][nc] = true;
                }
            }

            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }

    static boolean isIn(int r, int c, int N) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
