package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 댄스 파티
 * https://www.acmicpc.net/problem/2831
 */
public class baek2831 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> m0 = new PriorityQueue<>(); // -
        PriorityQueue<Integer> m1 = new PriorityQueue<>(); // +
        PriorityQueue<Integer> g0 = new PriorityQueue<>();
        PriorityQueue<Integer> g1 = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < 0) {
                m0.offer(-temp);
            } else {
                m1.offer(temp);
            }

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp < 0) {
                g0.offer(-temp);
            } else {
                g1.offer(temp);
            }
        }

        int answer = 0;
        while (!m0.isEmpty() && !g1.isEmpty()) {
            int a = m0.poll();
            if (g1.peek() < a) {
                answer++;
                g1.poll();
            }
        }

        while (!m1.isEmpty() && !g0.isEmpty()) {
            int a = g0.poll();
            if (m1.peek() < a) {
                answer++;
                m1.poll();
            }
        }
        System.out.println(answer);

    }
}
