package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 퇴사
 * https://www.acmicpc.net/problem/15486
 */
public class baek15486 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]);
    }
}
