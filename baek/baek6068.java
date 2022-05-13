package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 시간 관리하기
 * https://www.acmicpc.net/problem/6068
 */
public class baek6068 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return -Integer.compare(o1[1], o2[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            pq.add(new int[]{t, s});
        }

        int[] temp = pq.poll();
        int start = temp[1] - temp[0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (start < cur[1]) {
                start = start - cur[0];
            } else {
                start = cur[1] - cur[0];
            }
        }
        if (start < 0) {
            System.out.println(-1);
        } else {
            System.out.println(start);
        }
    }
}
