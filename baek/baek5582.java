package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 공통 부분 문자열
 * https://www.acmicpc.net/problem/5582
 */
public class baek5582 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int R = str1.length();
        int C = str2.length();

        int[][] dp = new int[R + 1][C + 1];
        int answer = 0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (str1.charAt(r - 1) == str2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1] + 1;
                    answer = Math.max(dp[r][c], answer);
                }
            }
        }

        System.out.println(answer);
    }
}
