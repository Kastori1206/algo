package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 두 개의 탑
 * https://www.acmicpc.net/problem/2118
 */
public class baek2118 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int l = 0, r = 0;

        int min = arr[l];
        long answer = 0;

        while (l <= r && r < N) {
            int m = (int) Math.min(min, sum - min);

            answer = Math.max(answer, m);

            if (min == m) {
                r++;
                min += arr[r];
            } else {
                min -= arr[l];
                l++;
            }
        }
        System.out.println(answer);
    }

}
