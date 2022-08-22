package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기 2
 * https://www.acmicpc.net/problem/14442
 */
public class baek14442 {
    static class Node {
        int r;
        int c;
        int k;
        int d;

        public Node(int r, int c, int k, int d) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.d = d;
        }
    }

    static int[][] map;
    static boolean[][][] visited;
    static int N, M, K;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c) - '0';
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, K, 1));
        visited[0][0][map[0][0] == 1 ? K-1 : K] = true;

        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == N - 1 && cur.c == M - 1) {
                answer = cur.d;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc][cur.k]) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    visited[nr][nc][cur.k] = true;
                    q.add(new Node(nr, nc, cur.k, cur.d + 1));
                } else {
                    if (cur.k > 0) {
                        visited[nr][nc][cur.k] = true;
                        q.add(new Node(nr, nc, cur.k - 1, cur.d + 1));
                    }
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
