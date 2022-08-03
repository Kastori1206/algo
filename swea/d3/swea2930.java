package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * swea2930. 힙
 */
public class swea2930 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t);
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());

                if (cmd == 1) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                } else {
                    if (pq.isEmpty()) {
                        sb.append(" ").append(-1);
                    } else {
                        sb.append(" ").append(pq.poll());

                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
