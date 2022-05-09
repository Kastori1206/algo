package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 받아쓰기
 * https://www.acmicpc.net/problem/20542
 */
public class baek20542 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= M; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                char a = A[i - 1];
                char b = B[j - 1];
                if (a == b || (a == 'v' && b == 'w') || (a == 'i' && (b == 'j' || b == 'l'))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        System.out.println(dp[N][M]);


    }
}
