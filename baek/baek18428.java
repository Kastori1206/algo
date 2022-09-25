package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 감시 피하기
 * https://www.acmicpc.net/problem/18428
 */
public class baek18428 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean flag;
    static List<Node> t;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        t = new ArrayList<>();
        map = new char[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().charAt(0);
                if (map[r][c] == 'T') {
                    t.add(new Node(r, c));
                }
            }
        }
        go(0, 0, 0);

        System.out.println(flag ? "YES" : "NO");
    }

    static void go(int r, int c, int cnt) {
        if (flag) {
            return;
        }
        if (cnt == 3) {
            flag = check();
            return;
        }
        for (int i = r; i < N; i++) {
            for (int j = c; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    go(i, j + 1, cnt + 1);
                    map[i][j] = 'X';
                }
            }
            c = 0;
        }
    }

    private static boolean check() {
        for (Node node : t) {
            for (int d = 0; d < 4; d++) {
                int nr = node.r;
                int nc = node.c;
                while (true) {
                    nr += dr[d];
                    nc += dc[d];

                    if (!isIn(nr, nc)) {
                        break;
                    }
                    if (map[nr][nc] == 'O') {
                        break;
                    }
                    if (map[nr][nc] == 'S') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
