package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 격자상의 경로
 * https://www.acmicpc.net/problem/10164
 */
public class baek10164 {
    static int N, M, K;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        map[0][1] = 1;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                map[r][c] = map[r - 1][c] + map[r][c - 1];
            }
        }

        if (K == 0) {
            System.out.println(map[N][M]);
        } else {
            int r1, c1, r2, c2;
            r1 = K / M + (K % M > 0 ? 1 : 0);
            c1 = K - (r1 - 1) * M;
            r2 = N - r1 + 1;
            c2 = M - c1 + 1;

            System.out.println(map[r1][c1] * map[r2][c2]);
        }
    }

}
