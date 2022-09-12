package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * LCD Test
 * https://www.acmicpc.net/problem/2290
 */
public class baek2290 {
    static char[][] answer;
    static int[][] map = {
            {0, 1, 1, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 0, 1, 1, 1, 1},
            {0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        String N = st.nextToken();

        int R = (s * 2) + 4;
        int C = (s + 4) * N.length();

        answer = new char[R][C];

        for (int r = 0; r < R; r++) {
            Arrays.fill(answer[r], ' ');
        }
        int idx = 0;
        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';
            if (map[n][1] == 1) {
                fill(0, 0, idx + 1, idx + s, '-');
            }
            if (map[n][4] == 1) {
                fill(s + 1, s + 1, idx + 1, idx + s, '-');
            }
            if (map[n][7] == 1) {
                fill(2 * (s + 1), 2 * (s + 1), idx + 1, idx + s, '-');
            }
            if (map[n][2] == 1) {
                fill(1, s, idx, idx, '|');
            }
            if (map[n][5] == 1) {
                fill(1 + (s + 1), s + (s + 1), idx, idx, '|');
            }

            if (map[n][3] == 1) {
                fill(1, s, idx + s + 1, idx + s + 1, '|');
            }
            if (map[n][6] == 1) {
                fill(1 + (s + 1), s + (s + 1), idx + s + 1, idx + s + 1, '|');
            }

            idx += s + 3;
        }

        for (int r = 0; r < R - 1; r++) {
            for (int c = 0; c < C - N.length(); c++) {
                System.out.print(answer[r][c]);
            }
            System.out.println();
        }
    }

    static void fill(int sr, int er, int sc, int ec, char ch) {
        for (int r = sr; r <= er; r++) {
            for (int c = sc; c <= ec; c++) {
                answer[r][c] = ch;
            }
        }
    }
}
