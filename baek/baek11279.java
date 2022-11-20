package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 최대 힙
 * https://www.acmicpc.net/problem/11279
 */
public class baek11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            pq.offer(x);
            if (x == 0) {
                answer.append(pq.poll()).append("\n");
            }
        }
        System.out.println(answer);
    }
}
