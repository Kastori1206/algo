package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 학부 연구생 민상
 * https://www.acmicpc.net/problem/21922
 */
public class baek21922 {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map, changeDir;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();

        map = new int[R][C];
        visited = new boolean[R][C];
        changeDir = new int[][]{
                {0, 1, 2, 3},
                {0, 1, -1, -1},
                {-1, -1, 2, 3},
                {3, 2, 1, 0},
                {2, 3, 0, 1}
        };

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 9) {
                    visited[r][c] = true;
                    list.add(new Node(r, c));
                }
            }
        }

        for (Node node : list) {
            for (int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if (!isIn(nr, nc)) {
                    continue;
                }
                dfs(nr, nc, d);
            }
        }

        int answer = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static void dfs(int r, int c, int d) {
        visited[r][c] = true;
        if (map[r][c] == 9) {
            return;
        }
        int nd = changeDir[map[r][c]][d];
        if (nd == -1) {
            return;
        }
        int nr = r + dr[nd];
        int nc = c + dc[nd];
        if (isIn(nr, nc)) {
            dfs(nr, nc, nd);
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
