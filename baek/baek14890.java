package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경사로
 * https://www.acmicpc.net/problem/14890
 */
public class baek14890 {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            //열
            if (go(i, 0, true)) {
                answer++;
            }
            //행
            if (go(0, i, false)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean go(int r, int c, boolean flag) {
        int[] h = new int[N];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (flag) {
                h[i] = map[r][i];
            } else {
                h[i] = map[i][c];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            if (h[i] == h[i + 1]) {
                continue;
            }
            if (h[i] - 1 == h[i + 1]) {
                for (int j = i + 1; j < i + 1 + L; j++) {
                    if (j > N - 1) {
                        return false;
                    }
                    if (visited[j]) {
                        return false;
                    }
                    if (h[i + 1] != h[j]) {
                        return false;
                    }
                    visited[j] = true;
                }

            } else if (h[i] + 1 == h[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0) {
                        return false;
                    }
                    if (visited[j]) {
                        return false;
                    }
                    if (h[i] != h[j]) {
                        return false;
                    }
                    visited[j] = true;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
