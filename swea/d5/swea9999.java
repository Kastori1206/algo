package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 9999. 광고 시간 정하기
 */
public class swea9999 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int L = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            boolean[] times = new boolean[100000000 + 1];

            int max = 0;
            int answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                max = Math.max(max, e);
                while (s < e) {
                    times[s++] = true;
                }
            }

            int l = 0;
            int r = L;
            int res = 0;
            for (int i = 0; i < L; i++) {
                if (times[i]) {
                    res++;
                }
            }
            answer = res;

            while (r < max) {
                if (times[l++]) {
                    res--;
                }
                if (times[r++]) {
                    res++;
                }

                answer = Math.max(answer, res);
            }

            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.print(sb);

    }
}


