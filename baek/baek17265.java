package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나의 인생에는 수학과 함께
 * https://www.acmicpc.net/problem/17265
 */
public class baek17265 {
    static char[][] map;
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().charAt(0);
            }
        }
        dfs(0, 0, map[0][0] - '0', ' ');
        System.out.println(max + " " + min);
    }

    static void dfs(int r, int c, int res, char value) {
        if (r == N - 1 && c == N - 1) {
            max = Math.max(res, max);
            min = Math.min(res, min);
            return;
        }
        for (int d = 0; d < 2; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (Character.isDigit(map[nr][nc])) {
                dfs(nr, nc, calc(res, map[nr][nc] - '0', value), value);
            } else {
                dfs(nr, nc, res, map[nr][nc]);
            }
        }
    }
    static int calc(int x, int y, char op) {
        switch (op) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
