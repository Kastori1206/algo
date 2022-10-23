package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 성곽
 * https://www.acmicpc.net/problem/2234
 */
public class baek2234 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    static int N, M;
    static int[][] map, map2;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        map2 = new int[M][N];
        visited = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int size = 0;
        int max = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c]) {
                    continue;
                }
                size++;
                max = Math.max(bfs(r, c), max);
            }
        }

        int max2 = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = 0; k < 4; k++) {
                    if ((map[r][c] & (1 << k)) == 0) {
                        continue;
                    }
                    visited = new boolean[M][N];
                    map[r][c] -= (1 << k);
                    max2 = Math.max(max2, bfs(r, c));
                    map[r][c] += (1 << k);
                }
            }
        }
        System.out.println(size);
        System.out.println(max);
        System.out.println(max2);
    }

    //11 1011
    private static int bfs(int sr, int sc) {
        Queue<Node> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.offer(new Node(sr, sc));

        int res = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            res++;
            for (int d = 0; d < 4; d++) {
                if ((map[cur.r][cur.c] & (1 << d)) == (1 << d)) {
                    continue;
                }

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                q.offer(new Node(nr, nc));
                visited[nr][nc] = true;

            }
        }
        return res;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }

}
