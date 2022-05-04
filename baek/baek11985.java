package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 오렌즈 출하
 * https://www.acmicpc.net/problem/11985
 */
public class baek11985 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 1];
        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
            dp[i] = Long.MAX_VALUE;
        }

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            long max = 0;
            long min = Long.MAX_VALUE;

            for (int j = 1; j <= M; j++) {
                if (i < j) {
                    break;
                }
                max = Math.max(max, arr[i - j + 1]);
                min = Math.min(min, arr[i - j + 1]);

                dp[i] = Math.min(dp[i], dp[i - j] + K + (long) j * (max - min));

            }
        }

        System.out.println(dp[N]);

    }
}
