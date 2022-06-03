package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나무꾼 이다솜
 * https://www.acmicpc.net/problem/1421
 */
public class baek1421 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long answer = Long.MIN_VALUE;

        for (int i = 1; i <= max; i++) {
            long sum = 0;
            for (int j = 0; j < N; j++) {
                int c = 0;
                if (arr[j] < i) {
                    continue;
                }
                if (arr[j] % i == 0) {
                    c = arr[j] / i - 1;
                } else {
                    c = arr[j] / i;
                }
                long temp = (long) W * i * (arr[j] / i) - ((long) c * C);
                if (temp > 0) {
                    sum += temp;
                }
            }
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
