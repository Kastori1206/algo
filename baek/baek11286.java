package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 절대값 힙
 * https://www.acmicpc.net/problem/11286
 */
public class baek11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    answer.append(0);
                } else {
                    answer.append(pq.poll()[0]);
                }
                answer.append("\n");
            } else {
                pq.offer(new int[]{x, Math.abs(x)});
            }

        }
        System.out.println(answer);
    }
}
