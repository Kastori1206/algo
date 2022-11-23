package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 새로운 게임
 * https://www.acmicpc.net/problem/17780
 */
public class baek17780 {
    static class Node {
        int r;
        int c;
        int d;

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

    static Node[] nodes;
    static int N, K;
    static int[][] map;
    static Deque<Integer>[][] chess;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        nodes = new Node[K];
        chess = new ArrayDeque[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                chess[r][c] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            nodes[i] = new Node(r, c, d);
            chess[r][c].offer(i);
        }

        int answer = 1;

        while (answer <= 1000) {
            for (int i = 0; i < K; i++) {
                Node cur = nodes[i];
                int r = cur.r;
                int c = cur.c;
                if (chess[r][c].getFirst() != i) {
                    continue;
                }
                int nr = r + dr[cur.d];
                int nc = c + dc[cur.d];

                if (!isIn(nr, nc) || map[nr][nc] == 2) {
                    int d = changeDir(cur.d);

                    nr = r + dr[d];
                    nc = c + dc[d];

                    if (!isIn(nr, nc) || map[nr][nc] == 2) {
                        nr = r;
                        nc = c;
                    } else if (map[nr][nc] == 0) {
                        white(r, c, nr, nc);
                    } else {
                        red(r, c, nr, nc);
                    }

                    nodes[i].r = nr;
                    nodes[i].c = nc;
                    nodes[i].d = d;

                } else if (map[nr][nc] == 0) {
                    white(r, c, nr, nc);
                } else if (map[nr][nc] == 1) {
                    red(r, c, nr, nc);
                }
                if (chess[nr][nc].size() >= 4) {
                    System.out.println(answer);
                    return;
                }
            }
            answer++;
        }

        System.out.println(-1);

    }


    private static int changeDir(int d) {
        if (d % 2 == 0) {
            d++;
        } else {
            d = (d + 3) % 4;
        }
        return d;
    }

    private static void white(int r, int c, int nr, int nc) {
        while (!chess[r][c].isEmpty()) {
            int idx = chess[r][c].pollFirst();
            nodes[idx].r = nr;
            nodes[idx].c = nc;

            chess[nr][nc].offer(idx);
        }
    }

    private static void red(int r, int c, int nr, int nc) {
        while (!chess[r][c].isEmpty()) {
            int idx = chess[r][c].pollLast();
            nodes[idx].r = nr;
            nodes[idx].c = nc;

            chess[nr][nc].offer(idx);
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}


