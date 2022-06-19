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

        int l = 0;
        int r = 2000000000;

        while (l + 1 < r) {
            int mid = (l + r) / 2;

            if (check(mid)) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }

    static boolean check(int mid) {
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] < mid) {
                sum += (mid - arr[i]);
                if (sum > K) {
                    return false;
                }
            }
        }
        return true;
    }
}
