package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 붙이기
 * https://www.acmicpc.net/problem/17136
 */
public class baek17136 {
    static int N = 10;
    static int[][] map = new int[N][N];
    static int answer;
    static int[] cnts = {5, 5, 5, 5, 5};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 10; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    static void dfs(int r, int c, int cnt) {
        if (cnt >= answer) {
            return;
        }
        if (r >= N - 1 && c > N - 1) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (c > N - 1) {
            dfs(r + 1, 0, cnt);
            return;
        }

        if (map[r][c] == 1) {
            for (int i = 4; i >= 0; i--) {
                if (cnts[i] <= 0) {
                    continue;
                }
                if (!check(r, c, i + 1)) {
                    continue;
                }

                change(r, c, i + 1, 0);
                cnts[i]--;
                dfs(r, c + 1, cnt + 1);
                change(r, c, i + 1, 1);
                cnts[i]++;
            }
        } else {
            dfs(r, c + 1, cnt);
        }
    }

    static void change(int r, int c, int size, int flag) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = flag;
            }
        }
    }

    static boolean check(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!isIn(i, j) || map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
