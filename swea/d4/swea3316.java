package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 3316. 동아리실 관리하기
 */
public class swea3316 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int MOD = 1_000_000_007;

        for (int t = 1; t <= T; t++) {
            String input = br.readLine();
            int N = input.length();

            long[][] dp = new long[N][16];

            for (int day = 0; day < N; day++) {
                int admin = 1 << (input.charAt(day) - 'A');

                for (int i = 0; i < 16; i++) {
                    if (day == 0) {
                        if ((i & admin) > 0 && (i & 1) > 0) {
                            dp[0][i] = 1;
                        }
                    } else {
                        if (dp[day - 1][i] == 0) {
                            continue;
                        }

                        for (int j = 0; j < 16; j++) {
                            if ((i & j) > 0 &&( admin & j) > 0) {
                                dp[day][j] += dp[day - 1][i];
                                dp[day][j] %= MOD;
                            }
                        }
                    }
                }
            }
            long answer = 0;
            for (int i = 0; i < 16; i++) {
                answer += dp[N - 1][i];
                answer %= MOD;
            }
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
}


