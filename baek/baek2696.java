package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 중앙값 구하기
 * https://www.acmicpc.net/problem/2696
 */
public class baek2696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int M = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            sb.append(M / 2 + 1).append("\n");

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (i % 2 == 1) {
                    pq1.offer(value);
                } else {
                    pq2.offer(value);
                }

                if (pq1.size() != 0 && pq2.size() != 0) {
                    pq2.offer(pq1.poll());
                    pq1.offer(pq2.poll());
                }

                if (i % 2 == 1) {
                    sb.append(pq1.peek()).append(" ");
                }
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());

                }
                if (i % 20 == 0) {
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
