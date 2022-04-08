package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 놀이 공원
 * https://www.acmicpc.net/problem/1561
 */
public class baek1561 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] time = new long[M];

        st = new StringTokenizer(br.readLine());
        long max = 0;

        for (int i = 0; i < M; i++) {
            time[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, time[i]);
        }
        if (N <= M) {
            System.out.println(N);
            return;
        }

        long start = 1;
        long end = max * N;
        long mm = max * N;

        while (start < end) {
            long mid = (start + end) / 2;
            long res = 0;

            for (int i = 0; i < M; i++) {
                res += (mid / time[i]) + 1;
            }
            if (res < N) {
                start = mid + 1;
            } else {
                mm = Math.min(mm, mid);
                end = mid;
            }
        }

        long res = 0;
        for (int i = 0; i < M; i++) {
            res += ((mm - 1) / time[i]) + 1;
        }

        for (int i = 0; i < M; i++) {
            if (mm % time[i] == 0) {
                res++;
                if (res == N) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
}
