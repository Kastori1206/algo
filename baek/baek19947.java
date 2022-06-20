package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 투자의 귀재 배주형
 * https://www.acmicpc.net/problem/19947
 */
public class baek19947 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        long[] dp = new long[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            dp[i] = (long) Math.floor(dp[i - 1] * 1.05);
            if (i >= 3) {
                dp[i] = Math.max((long) Math.floor(dp[i - 3] * 1.2), dp[i]);
            }
            if (i >= 5) {
                dp[i] = Math.max((long) Math.floor(dp[i - 5] * 1.35), dp[i]);
            }
        }
        System.out.println(dp[Y]);
    }
}
