package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 흩날리는 시험지 속에서 내 평점이 느껴진거야
 * https://www.acmicpc.net/problem/17951
 */
public class baek17951 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int l = 0;
        int r = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            r += arr[i];
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            int cnt = 1;
            int sum = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                sum += arr[i];
                if (sum >= mid) {
                    cnt++;
                    min = Math.min(min, sum);
                    sum = 0;
                }
            }

            if (cnt > K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l - 1);


    }
}
