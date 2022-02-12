package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 로봇
 * https://www.acmicpc.net/problem/1726
 */
public class baek1726 {
    static int[][] map;
    static boolean[][][] visited;
    //동 서 남 북
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int R, C, answer;

    static class Node {
        int r, c, d, cnt;

        public Node(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C][4];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                0);
        st = new StringTokenizer(br.readLine());
        Node end = new Node(Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()) - 1,
                0);

        bfs(start, end);

        System.out.println(answer);
    }

    static void bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c][start.d] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.r == end.r && cur.c == end.c && cur.d == end.d) {
                answer = cur.cnt;
                return;
            }

            for (int k = 1; k < 4; k++) {
                int nr = cur.r + dr[cur.d] * k;
                int nc = cur.c + dc[cur.d] * k;

                if (!isIn(nr, nc) || map[nr][nc] == 1) {
                    break;
                }

                if (visited[nr][nc][cur.d]) {
                    continue;
                }
                visited[nr][nc][cur.d] = true;
                q.offer(new Node(nr, nc, cur.d, cur.cnt + 1));

            }

            for (int d = 0; d < 4; d++) {
                if (cur.d == d) {
                    continue;
                }
                if (visited[cur.r][cur.c][d]) {
                    continue;
                }
                visited[cur.r][cur.c][d] = true;
                if (checkDir(cur.d, d)) {
                    q.offer(new Node(cur.r, cur.c, d, cur.cnt + 2));
                } else {
                    q.offer(new Node(cur.r, cur.c, d, cur.cnt + 1));
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static boolean checkDir(int dir1, int dir2) {
        return dir1 == 0 && dir2 == 1 || dir1 == 1 && dir2 == 0 || dir1 == 2 && dir2 == 3 || dir1 == 3 && dir2 == 2;
    }
}
