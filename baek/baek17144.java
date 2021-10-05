package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미세먼지 안녕!
 * https://www.acmicpc.net/problem/17144
 */
public class baek17144 {
    static class Node {
        int r, c, dust;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int dust) {
            this.r = r;
            this.c = c;
            this.dust = dust;
        }
    }

    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    //반시계
    static int[] d1 = {1, 0, -1, 0};

    static int R, C, T;
    static Node[] airClear;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        airClear = new Node[2];
        int idx = 0;

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1) {
                    airClear[idx++] = new Node(r, c);
                }
            }
        }
        Queue<Node> q = new LinkedList<>();
        for (int t = 0; t < T; t++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    int dust = map[r][c];
                    if (dust > 0) {
                        q.offer(new Node(r, c, (int) Math.floor(dust / 5)));
                    }
                }
            }

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == -1) {
                        continue;
                    }

                    map[nr][nc] += cur.dust;
                    map[cur.r][cur.c] -= cur.dust;
                }
            }
            airPurication(airClear[0], dr);
            airPurication(airClear[1], d1);
        }
        int answer = 0;
        for (int[] a : map) {
            for (int n : a) {
                answer += n;
            }
        }
        System.out.println(answer + 2);

    }

    static void airPurication(Node cur, int[] dir) {
        int r = cur.r + dir[0];
        int c = 0;

        for (int d = 0; d < 4; d++) {
            while (true) {
                int nr = r + dir[d];
                int nc = c + dc[d];

                if (!isIn(nr, nc)) {
                    break;
                }
                if (map[nr][nc] == -1) {
                    break;
                }
                map[r][c] = map[nr][nc];
                r = nr;
                c = nc;

                if (c == C - 1 && r == cur.r) {
                    break;
                }
            }
        }
        map[r][c] = 0;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
