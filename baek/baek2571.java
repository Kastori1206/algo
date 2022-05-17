package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 - 3
 * https://www.acmicpc.net/problem/2571
 */
public class baek2571 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[100][100];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int rr = Integer.parseInt(st.nextToken());
            int cc = Integer.parseInt(st.nextToken());

            for (int r = rr; r < rr + 10; r++) {
                for (int c = cc; c < cc + 10; c++) {
                    map[r][c] = 1;
                }
            }
        }
        int answer = 0;

        for (int r = 1; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] == 0) {
                    continue;
                }
                map[r][c] += map[r - 1][c];
            }
        }

        for (int r = 1; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                int h = 100;
                for (int k = c; k < 100; k++) {
                    h = Math.min(h, map[r][k]);

                    if (h == 0) {
                        break;
                    }

                    int area = h * (k - c + 1);
                    answer = Math.max(answer, area);
                }

            }
        }
        System.out.println(answer);
    }
}
