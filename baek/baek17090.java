package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 미로 탈출하기
 * https://www.acmicpc.net/problem/17090
 */
public class baek17090 {
    static int N, M, answer;
    static int[][] map, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];

        for (int r = 0; r < N; r++) {
            Arrays.fill(dp[r], -1);

            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                char ch = input.charAt(c);
                map[r][c] = getDir(ch);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                answer += dfs(r, c);
            }
        }
        System.out.println(answer);
    }

    private static int dfs(int r, int c) {
        if (!isIn(r, c)) {
            return 1;
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        int d = map[r][c];
        int nr = r + dr[d];
        int nc = c + dc[d];
        dp[r][c] = dfs(nr, nc);
        return dp[r][c];
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static int getDir(char ch) {
        if (ch == 'U') {
            return 0;
        } else if (ch == 'D') {
            return 1;
        } else if (ch == 'L') {
            return 2;
        } else {
            return 3;
        }
    }
}
