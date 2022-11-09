package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 위의 공
 * https://www.acmicpc.net/problem/16957
 */
public class baek16957 {
    static int R, C;
    static int[][] map;
    static int[] p, answer;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        p = new int[R * C];
        answer = new int[R * C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                getParent(r, c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer[find(r * C + c)]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(answer[r * C + c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    private static void getParent(int sr, int sc) {
        int r = sr;
        int c = sc;
        for (int d = 0; d < 8; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            if (!isIn(nr, nc)) {
                continue;
            }

            if (map[r][c] <= map[nr][nc]) {
                continue;
            }

            r = nr;
            c = nc;
        }

        p[sr * C + sc] = r * C + c;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
