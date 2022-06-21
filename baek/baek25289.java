package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 등차 부분 수열
 * https://www.acmicpc.net/problem/25289
 */
public class baek25289 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        for (int d = -99; d <= 99; d++) {
            int[] dp = new int[100 + 1];
            for (int i = 0; i < N; i++) {
                if (arr[i] - d < 1 || arr[i] - d > 100) {
                    dp[arr[i]] = 1;
                } else {
                    dp[arr[i]] = dp[arr[i] - d] + 1;
                }
                answer = Math.max(answer, dp[arr[i]]);
            }
        }

        System.out.println(answer);

    }

}

