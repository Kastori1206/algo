package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 빛
 * https://www.acmicpc.net/problem/10427
 */
public class baek10427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            long[] sum = new long[N + 1];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i - 1] + arr[i - 1];
            }

            long answer = 0;
            for (int m = 2; m <= N; m++) {
                long min = Long.MAX_VALUE;
                for (int i = 0; i <= N - m; i++) {
                    min = Math.min(((long) arr[i + m - 1] * m) - (sum[i + m] - sum[i]), min);
                }
                answer += min;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }


}
