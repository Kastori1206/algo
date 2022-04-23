package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 녹색 옷 입은 애가 젤다지?
 * https://www.acmicpc.net/problem/4485
 */
public class baek4485 {
    static class Node implements Comparable<Node> {
        int r, c, w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(w, o.w);
        }
    }

    static int N;
    static int[][] map, dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int t = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            map = new int[N][N];
            dist = new int[N][N];

            for (int r = 0; r < N; r++) {
                Arrays.fill(dist[r], Integer.MAX_VALUE);
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(t++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);

    }

    static int dijkstra() {
        dist[0][0] = map[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (dist[nr][nc] > dist[cur.r][cur.c] + map[nr][nc]) {
                    dist[nr][nc] = dist[cur.r][cur.c] + map[nr][nc];
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
        return dist[N - 1][N - 1];
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
