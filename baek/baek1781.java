package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 컵라면
 * https://www.acmicpc.net/problem/1781
 */
public class baek1781 {
    static class Node implements Comparable<Node>{
        int d, c;

        public Node(int d, int c) {
            this.d = d;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            //데드라인이 작은거 부터, 같으면 컵라면 갯수가 큰거부터
            if (this.d == o.d) {
                return -Integer.compare(this.c, o.c);
            }
            return Integer.compare(this.d,o.d);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "d=" + d +
                    ", c=" + c +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Node(d, c));
        }

        Collections.sort(list);

        long answer = 0;
        for (Node cur : list) {
            int size = pq.size();
            if (size < cur.d) {
                pq.offer(cur.c);
            } else if (size == cur.d) {
                if (pq.peek() < cur.c) {
                    pq.poll();
                    pq.offer(cur.c);
                }
            }
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}

