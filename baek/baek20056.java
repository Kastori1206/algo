package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 마법사 상어와 파이어볼
 * https://www.acmicpc.net/problem/20056
 */
public class baek20056 {
    static class Node {
        int r;
        int c;
        int m;
        int s;
        int d;
        int cnt;

        public Node() {
        }

        public Node(int r, int c, int m, int s, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;

    static Node[][] map;
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Node[N][N];
        q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.offer(new Node(r, c, m, s, d, 1));
        }

        for (int i = 0; i < K; i++) {
            move();
            work();
        }

        int answer = 0;
        while (!q.isEmpty()) {
            answer += q.poll().m;
        }

        System.out.println(answer);
    }

    private static void work() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == null) {
                    continue;
                }

                int rr = map[r][c].r;
                int cc = map[r][c].c;
                int m = map[r][c].m;
                int s = map[r][c].s;
                int d = map[r][c].d;
                int cnt = map[r][c].cnt;
                if (cnt == 1) {
                    q.offer(new Node(rr, cc, m, s, d, 1));
                } else if (m / 5 != 0) {
                    for (int i = d == -1 ? 1 : 0; i < 8; i += 2) {
                        q.offer(new Node(rr, cc, m / 5, s / cnt, i, 1));
                    }
                }
                map[r][c] = null;
            }
        }
    }

    private static void move() {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            Node node = q.poll();
            int nr = (node.r + N + ((node.s % N) * dr[node.d])) % N;
            int nc = (node.c + N + ((node.s % N) * dc[node.d])) % N;

            if (map[nr][nc] == null) {
                node.r = nr;
                node.c = nc;
                map[nr][nc] = node;
            } else {
                map[nr][nc].m += node.m;
                map[nr][nc].s += node.s;
                map[nr][nc].cnt++;
                if (map[nr][nc].d != -1) {
                    map[nr][nc].d = (map[nr][nc].d % 2 == node.d % 2 ? map[nr][nc].d : -1);
                }
            }
        }
    }
}
