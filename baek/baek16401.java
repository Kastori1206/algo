package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 과자 나눠주기
 * https://www.acmicpc.net/problem/16401
 */
public class baek16401 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 1;
        int r = 2000000000;
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= M) {
                l = mid + 1;
                answer = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
