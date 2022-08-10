package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11446. 사탕 가방
 */
public class swea11446 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long l = 1;
            long r = 0;
            long[] arr = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
                r = Math.max(r, arr[i]);
            }

            while (l <= r) {
                long mid = (l + r) / 2;
                long res = 0;

                for (int i = 0; i < N; i++) {
                    res += arr[i] / mid;
                }

                if (res < M) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(String.format("#%d %d\n", t, r));
        }
        System.out.print(sb);
    }
}
