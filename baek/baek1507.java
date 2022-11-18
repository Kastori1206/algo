package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 궁금한 민호
 * https://www.acmicpc.net/problem/1507
 */
public class baek1507 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] d = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int w = Integer.parseInt(st.nextToken());
                map[r][c] = w;
                d[r][c] = w;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        System.out.println(-1);
                        return;
                    }
                    if (map[i][j] == map[i][k] + map[k][j]) {
                        d[i][j] = 0;
                    }
                }
            }
        }
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                answer += d[r][c];
            }
        }

        System.out.println(answer / 2);
    }
}
