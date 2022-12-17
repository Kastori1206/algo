package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * N번쨰 큰 수
 * https://www.acmicpc.net/problem/2075
 */
public class baek2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
