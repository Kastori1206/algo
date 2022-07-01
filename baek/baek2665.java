package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 미로만들기
 * https://www.acmicpc.net/problem/2665
 */
public class baek2665 {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int b;

        public Node(int r, int c, int b) {
            this.r = r;
            this.c = c;
            this.b = b;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(b, o.b);
        }

    }

    static int N, answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = input.charAt(c) - '0';
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        answer = map[0][0] == 0 ? 1 : 0;
        pq.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.r == N - 1 && cur.c == N - 1) {
                answer = map[cur.r][cur.c] == 0 ? cur.b + 1 : cur.b;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                pq.offer(new Node(nr, nc, map[nr][nc] == 0 ? cur.b + 1 : cur.b));
            }
        }
        System.out.println(answer);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
