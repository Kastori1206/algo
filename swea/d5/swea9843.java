package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 9843. 촛불 이벤트
 */
public class swea9843 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            long N = Long.parseLong(br.readLine());

            long l = 1;
            long r = 2000000000;

            long answer = -1;

            while (l < r) {
                long mid = (l + r) / 2;

                long res = (mid * mid + mid);
                if (res == N * 2) {
                    answer = mid;
                    break;
                }

                if (res > N * 2) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
}



