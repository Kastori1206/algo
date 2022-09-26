package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 흙길 보수하기
 * https://www.acmicpc.net/problem/1911
 */
public class baek1911 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{s, e});

        }
        long idx = 0;
        long answer = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            long s = cur[0];
            long e = cur[1];

            if (e < idx) {
                continue;
            }
            if (idx > s) {
                s = idx;
            }
            long len = e - s;
            long cnt = len / L;
            if (len % L != 0) {
                cnt++;
            }

            answer += cnt;
            idx = cnt * L + s;
        }


        System.out.println(answer);
    }
}
