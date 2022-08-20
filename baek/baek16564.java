package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 히오스 프로게이머
 * https://www.acmicpc.net/problem/16564
 */
public class baek16564 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = 0;
        int l = arr[0];
        int r = arr[N - 1] + K;

        while (l <= r) {
            int mid = (l + r) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] < mid) {
                    sum += (mid - arr[i]);
                }
            }
            if (sum <= K) {
                answer = Math.max(answer,mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
