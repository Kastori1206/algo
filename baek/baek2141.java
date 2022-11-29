package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 우체국
 * https://www.acmicpc.net/problem/2141
 */
public class baek2141 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][2];
        long res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            res += arr[i][1];
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Long.compare(o1[1], o2[1]);
            }
            return Long.compare(o1[0], o2[0]);
        });

        long sum = 0;
        for (long[] temp : arr) {
            long x = temp[0];
            long a = temp[1];

            sum += a;
            if (sum >= (res + 1) / 2) {
                System.out.println(x);
                return;
            }
        }

    }
}
