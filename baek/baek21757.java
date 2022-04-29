package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나누기
 * https://www.acmicpc.net/problem/21757
 */
public class baek21757 {
    static int N;
    static int[] arr, sum;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new int[N + 1];
        dp = new long[N + 1][5];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        System.out.println(go());
    }

    static long go() {
        long query = sum[N] / 4;
        if (query * 4 != sum[N]) {
            return 0;
        }

        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = dp[i - 1][j];
                if (query * j == sum[i]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[N - 1][3];
    }
}
