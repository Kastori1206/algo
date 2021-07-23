package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 크리스마스 트리
 * https://www.acmicpc.net/problem/1234
 */
public class baek1234 {
    static int N, R, G, B;
    static long[][][][] RGB = new long[11][101][101][101];
    static long[][] dp = new long[11][11];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        System.out.println(go(N, R, G, B));
    }

    static long go(int n, int r, int g, int b) {

        if (r < 0 || g < 0 || b < 0) return 0;
        if (n <= 0) return 1;

        if (RGB[n][r][g][b] != 0) return RGB[n][r][g][b];

        // 1가지 색
        RGB[n][r][g][b] += go(n - 1, r - n, g, b);
        RGB[n][r][g][b] += go(n - 1, r, g - n, b);
        RGB[n][r][g][b] += go(n - 1, r, g, b - n);

        // 2가지 색
        if (n % 2 == 0) {
            int num = n / 2;
            long result = calc(n, num, 2);

            RGB[n][r][g][b] += result * go(n - 1, r - num, g - num, b);
            RGB[n][r][g][b] += result * go(n - 1, r - num, g, b - num);
            RGB[n][r][g][b] += result * go(n - 1, r, g - num, b - num);
        }

        // 3가지 색
        if (n % 3 == 0) {
            int num = n / 3;
            long result = calc(n, num, 3);

            RGB[n][r][g][b] += result * go(n - 1, r - num, g - num, b - num);
        }

        return RGB[n][r][g][b];
    }

    static long calc(int n, int num, int k) {
        if (dp[n][num] != 0) return dp[n][num];

        long result = 1L;

        for (int i = 1; i <= n; i++) {
        	result *= i;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= num; j++) {
            	result /= j;
            }
        }
        dp[n][num] = result;
        return result;
    }
}


