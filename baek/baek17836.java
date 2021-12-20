package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 공주님을 구해라!
 * https://www.acmicpc.net/problem/17836
 */
public class baek17836 {
    static class Node {
        int r, c, d;
        boolean key;

        public Node(int r, int c, int d, boolean key) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.key = key;
        }
    }

    static int R, C, T;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C][2];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        int answer = bfs(new Node(0, 0, 0, false));
        if (answer == -1) {
            System.out.println("Fail");
        } else {
            System.out.println(answer);
        }
    }

    static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.d > T) {
                break;
            }
            if (cur.r == R - 1 && cur.c == C - 1) {
                return cur.d;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (cur.key) {
                    if (visited[nr][nc][1]) {
                        continue;
                    }
                    q.offer(new Node(nr, nc, cur.d + 1, true));
                    visited[nr][nc][1] = true;
                } else {
                    if (visited[nr][nc][0]) {
                        continue;
                    }
                    if (map[nr][nc] == 1) {
                        continue;
                    }

                    if (map[nr][nc] == 0) {
                        q.offer(new Node(nr, nc, cur.d + 1, false));
                    } else {
                        q.offer(new Node(nr, nc, cur.d + 1, true));
                    }
                    visited[nr][nc][0] = true;
                }
            }
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
