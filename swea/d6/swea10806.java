package swea.d6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 10806. 수 만들기
 */
public class swea10806 {
    static class Node implements Comparable<Node>{
        int left, cnt;


        public Node(int left, int cnt) {
            this.left = left;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cnt, o.cnt);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(K, 0));

            int answer = K;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (cur.left == 0) {
                    answer = cur.cnt;
                    break;
                }
                pq.offer(new Node(0, cur.left + cur.cnt));
                for (int i = 0; i < N; i++) {
                    pq.offer(new Node(cur.left / arr[i], cur.cnt + cur.left % arr[i]));
                }
            }

            sb.append(String.format("#%d %d\n", t, answer));

        }
        System.out.print(sb);

    }
}
