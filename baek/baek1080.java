package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬
 * https://www.acmicpc.net/problem/1080
 */
public class baek1080 {
    static int N, M;
    static int[][] map, target;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        target = new int[N][M];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                target[r][c] = input.charAt(c) - '0';
            }
        }

        int answer = 0;

        for (int r = 0; r < N - 2; r++) {
            for (int c = 0; c < M - 2; c++) {
                if (map[r][c] == target[r][c]) {
                    continue;
                }
                change(r, c);
                answer++;
            }
        }

        if (!check()) {
            answer = -1;
        }
        System.out.println(answer);

    }

    private static boolean check() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != target[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void change(int sr, int sc) {
        for (int r = sr; r <= sr + 2; r++) {
            for (int c = sc; c <= sc + 2; c++) {
                map[r][c] = 1 - map[r][c];
            }
        }
    }
}
