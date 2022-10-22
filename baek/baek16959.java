package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 체스판 여행 1
 * https://www.acmicpc.net/problem/16959
 */
public class baek16959 {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int t;
        int m;// 0 : 나이트,1: 룩, 2: 비숍

        int next;

        public Node(int r, int c, int t, int m, int next) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.m = m;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(t, o.t);
        }
    }

    static int N;
    static int[][] map;
    static boolean[][][][] visited;
    static int[][] dr = {
            {-1, -2, -2, -1, 1, 2, 2, 1},
            {-1, 1, 0, 0},
            {-1, -1, 1, 1}
    };
    static int[][] dc = {
            {-2, -1, 1, 2, 2, 1, -1, -2},
            {0, 0, -1, 1},
            {-1, 1, 1, -1}
    };
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N][3][N * N + 1];
        pq = new PriorityQueue<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    for (int i = 0; i < 3; i++) {
                        pq.offer(new Node(r, c, 0, i, 2));
                        visited[r][c][i][2] = true;
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            int r = cur.r;
            int c = cur.c;
            int m = cur.m;
            int t = cur.t;
            int next = cur.next;

            if (next == N * N + 1) {
                return cur.t;
            }

            for (int i = 0; i < 3; i++) {
                if (m == i || visited[r][c][i][next]) {
                    continue;
                }
                pq.offer(new Node(r, c, t + 1, i, next));
                visited[r][c][i][next] = true;
            }

            if (m == 0) {
                for (int d = 0; d < dr[0].length; d++) {
                    int nr = r + dr[0][d];
                    int nc = c + dc[0][d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc][0][next]) {
                        continue;
                    }

                    if (map[nr][nc] == next) {
                        pq.offer(new Node(nr, nc, t + 1, m, next + 1));
                    } else {
                        pq.offer(new Node(nr, nc, t + 1, m, next));
                    }
                }
            } else {
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[m][d];
                    int nc = c + dc[m][d];

                    while (isIn(nr, nc)) {
                        if (!visited[nr][nc][m][next]) {
                            visited[nr][nc][m][next] = true;

                            if (map[nr][nc] == next) {
                                pq.offer(new Node(nr, nc, t + 1, m, next + 1));
                            } else {
                                pq.offer(new Node(nr, nc, t + 1, m, next));
                            }
                        }
                        nr += dr[m][d];
                        nc += dc[m][d];
                    }
                }
            }
        }

        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
