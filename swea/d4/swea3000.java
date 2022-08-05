package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 3000. 중간값 구하기
 */
public class swea3000 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int MOD = 20171109;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());
            long answer = 0;

            PriorityQueue<Integer> min = new PriorityQueue<>();
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (mid > a) {
                    max.offer(a);
                } else {
                    min.offer(a);
                }

                if (mid > b) {
                    max.offer(b);
                } else {
                    min.offer(b);
                }

                while (min.size() > max.size()) {
                    max.offer(mid);
                    mid = min.poll();
                }

                while (max.size() > min.size()) {
                    min.offer(mid);
                    mid = max.poll();
                }

                answer = (answer + mid) % MOD;
            }
            sb.append(String.format("#%d %d\n", t, answer));

        }
        System.out.println(sb);
    }
}
