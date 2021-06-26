package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 별 찍기 - 10
 * https://www.acmicpc.net/problem/2447
 */
public class baek2447 {
    static char[][] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new char[N][N];
        for (int r = 0; r < N; r++) {
            Arrays.fill(answer[r], ' ');
        }
        go(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(answer[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void go(int r, int c, int N) {
        if (N == 1) {
            answer[r][c] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1))
                    go(r + i * (N / 3), c + j * (N / 3), N / 3);
            }
        }
    }
}
