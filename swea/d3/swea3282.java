package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3282. 0/1 Knapsack
 */
public class swea3282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] V = new int[N + 1];
            int[] C = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                V[i] = Integer.parseInt(st.nextToken());
                C[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (V[i] <= j) {
                        dp[i][j] = Math.max(C[i] + dp[i - 1][j - V[i]], dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                    answer = Math.max(dp[i][j], answer);
                }
            }
            sb.append(String.format("#%d %d\n", t, answer));


        }//test_case
        System.out.println(sb);

    }//main
}
