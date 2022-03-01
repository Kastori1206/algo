package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */
public class baek7569 {
    static class Node {
        int r, c, h;

        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", h=" + h +
                    '}';
        }
    }
    static int N, M, H;
    static int[][][] map;
    static boolean[][][] visited;
    static int[] dr = {0, -1, 0, 0, 1, 0};
    static int[] dc = {-1, 0, 0, 1, 0, 0};
    static int[] dh = {0, 0, -1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        visited = new boolean[N][M][H];
        Queue<Node> q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < M; c++) {
                    map[r][c][h] = Integer.parseInt(st.nextToken());
                    if (map[r][c][h] == 1) {
                        q.offer(new Node(r, c, h));
                        visited[r][c][h] = true;
                    } else if (map[r][c][h] == -1) {
                        visited[r][c][h] = true;
                    }
                }
            }
        }
        int answer = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();

                for (int d = 0; d < 6; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    int nh = cur.h + dh[d];

                    if (!isIn(nr, nc, nh)) {
                        continue;
                    }
                    if (visited[nr][nc][nh]) {
                        continue;
                    }
                    if (map[nr][nc][nh] != 0) {
                        continue;
                    }
                    visited[nr][nc][nh] = true;
                    q.offer(new Node(nr, nc, nh));
                }
            }
        }
        System.out.println(check() ? answer : -1);

    }

    static boolean check() {
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c][h]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean isIn(int r, int c, int h) {
        return r >= 0 && r < N && c >= 0 && c < M && h >= 0 && h < H;
    }
}

