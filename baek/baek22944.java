package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 죽음의 비
 * https://www.acmicpc.net/problem/22944
 */
public class baek22944 {
    static class Node {
        int r;
        int c;
        int u;
        int h;

        public Node(int r, int c, int u, int h) {
            this.r = r;
            this.c = c;
            this.u = u;
            this.h = h;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, H, D;
    static int[][] visited;
    static char[][] map;
    static Node start;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new int[N][N];

        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 'S') {
                    start = new Node(r, c, 0, H);
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c] = start.h;
        q.add(start);

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (--size >= 0) {
                Node cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == 'E') {
                        return dist + 1;
                    }

                    int nu = cur.u;
                    int nh = cur.h;
                    if (map[nr][nc] == 'U') {
                        nu = D;
                    }
                    if (nu != 0) {
                        nu--;
                    } else {
                        nh--;
                    }

                    if (nh == 0) {
                        continue;
                    }
                    if (visited[nr][nc] < nh + nu) {
                        visited[nr][nc] = nh + nu;
                        q.offer(new Node(nr, nc, nu, nh));
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
