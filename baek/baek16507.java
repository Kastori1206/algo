package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 어두운 건 무서워
 * https://www.acmicpc.net/problem/16507
 */
public class baek16507 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[][] map = new long[R + 1][C + 1];
        long[][] sum = new long[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                sum[r][c] = sum[r - 1][c] + sum[r][c - 1] + map[r][c] - sum[r - 1][c - 1];
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            long res = sum[r2][c2] - sum[r1 - 1][c2] - sum[r2][c1 - 1] + sum[r1 - 1][c1 - 1];
            int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);

            res /= cnt;
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}
