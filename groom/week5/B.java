package groom.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> oceans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        oceans = new LinkedList<>();

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 0) {
                    oceans.offer(new Node(r, c));
                }
            }
        }
        int answer = 0;
        boolean flag = false;
        while (true) {
            if (isfull()) {
                break;
            }
            visited = new boolean[N][M];
            int area = check();
            if (area > 1) {
                flag = true;
                break;
            }
            int size = oceans.size();

            for (int i = 0; i < size; i++) {
                Node cur = oceans.poll();
                int r = cur.r;
                int c = cur.c;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == 0) {
                        continue;
                    }
                    map[nr][nc] = 0;
                    oceans.offer(new Node(nr, nc));
                }
            }
            answer++;
        }

        System.out.println(flag ? answer : -1);

    }

    private static boolean isfull() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int check() {
        int res = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c]) {
                    continue;
                }
                if (map[r][c] == 0) {
                    continue;
                }
                bfs(r, c);
                res++;
            }
        }
        return res;
    }

    private static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Node(r, c));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
