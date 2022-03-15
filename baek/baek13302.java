package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 리조트
 * https://www.acmicpc.net/problem/13302
 */
public class baek13302 {
    static int[][] dp;
    static boolean[] rests;
    static int N, M;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        rests = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = INF;
            }
        }

        if (M != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int day = Integer.parseInt(st.nextToken());
                rests[day] = true;
            }
        }

        System.out.println(dfs(1, 0));

    }

    static int dfs(int day, int coupon) {
        if (day > N) {
            return 0;
        }

        if (dp[day][coupon] != INF) {
            return dp[day][coupon];
        }
        if (rests[day]) {
            dp[day][coupon] = dfs(day + 1, coupon);
            return dp[day][coupon];
        }

        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon) + 10000);
        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 3, coupon + 1) + 25000);
        dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 5, coupon + 2) + 37000);

        if (coupon >= 3) {
            dp[day][coupon] = Math.min(dp[day][coupon], dfs(day + 1, coupon - 3));
        }

        return dp[day][coupon];
    }
}
