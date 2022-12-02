package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연료 채우기
 * https://www.acmicpc.net/problem/1826
 */

public class baek1826 {
    static class Node implements Comparable<Node> {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(a, o.a);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Node(a, b);
        }
        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(arr);
        int idx = 0;
        int answer = 0;
        while (P < L) {
            while (idx < N && arr[idx].a <= P) {
                pq.offer(arr[idx].b);
                idx++;
            }
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            answer++;
            P += pq.poll();
        }

        System.out.println(answer);

    }

}
