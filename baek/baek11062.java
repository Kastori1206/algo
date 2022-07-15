package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 카드 게임
 * https://www.acmicpc.net/problem/11062
 */
public class baek11062 {
    static int N;
    static int[][] dp;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N][N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, N - 1, true);
            sb.append(dp[0][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int l, int r, boolean flag) {
        if (l > r) {
            return 0;
        }

        if (dp[l][r] != 0) {
            return dp[l][r];
        }

        if (flag) {
            return dp[l][r] = Math.max(arr[l] + dfs(l + 1, r, false), arr[r] + dfs(l, r - 1, false));
        } else {
            return dp[l][r] = Math.min(dfs(l + 1, r, true), dfs(l, r - 1, true));
        }
    }
}
