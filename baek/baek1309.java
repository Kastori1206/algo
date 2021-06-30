package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 동물원
 * https://www.acmicpc.net/problem/1309
 */
public class baek1309 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            //사자가 i번째 줄에 없어도 되는 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            //i번째 1번째 칸에 사자가 있는 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            //i번째 2번째 칸에 사자가 있는 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);

    }
}
