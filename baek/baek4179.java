package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 불!
 * https://www.acmicpc.net/problem/4179
 */
public class baek4179 {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node> fires, q;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        q = new LinkedList<>();
        fires = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'J') {
                    q.offer(new Node(r, c));
                    visited[r][c] = true;
                } else if (map[r][c] == 'F') {
                    fires.offer(new Node(r, c));
                }
            }
        }
        String answer = "IMPOSSIBLE";
        int res = 0;
        boolean flag = false;

        while (!q.isEmpty() && !flag) {
            int size = q.size();
            moveFire();
            res++;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isIn(nr, nc)) {
                        flag = true;
                        answer = res + "";
                        break;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (map[nr][nc] != '.') {
                        continue;
                    }

                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        System.out.println(answer);
    }

    static void moveFire() {
        int size = fires.size();
        for (int i = 0; i < size; i++) {
            Node cur = fires.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] == '#' || map[nr][nc] == 'F') {
                    continue;
                }

                fires.offer(new Node(nr, nc));
                map[nr][nc] = 'F';
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
