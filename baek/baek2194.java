package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 유닛 이동시키기
 * https://www.acmicpc.net/problem/2194
 */
public class baek2194 {
    static class Node {
        int r, c, d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    '}';
        }
    }

    static int N, M, A, B;
    static boolean[][] map, visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = true;
        }
        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);
        st = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0);

        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.d, o2.d);
            }
        });
        q.add(start);
        visited[start.r][start.c] = true;
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == end.r && cur.c == end.c) {
                answer = cur.d;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!check(nr, nc)) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new Node(nr, nc, cur.d + 1));
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static boolean check(int sr, int sc) {
        for (int r = sr; r < sr + A ; r++) {
            for (int c = sc; c < sc + B; c++) {
                if (!isIn(r, c)) {
                    return false;
                }
                if (map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
