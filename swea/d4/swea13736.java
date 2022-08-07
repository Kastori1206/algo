package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 13736. 사탕 분배
 */
public class swea13736 {
    static long c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());

            c = a + b;
            long res = (a * pow(2, K)) % c;

            long answer = Math.min(res, c - res);

            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }

    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long res = pow(a, b / 2);
        if (b % 2 == 0) {
            return (res * res) % c;
        } else {
            return (res * res * a) % c;
        }
    }
}