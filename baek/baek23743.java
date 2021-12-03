package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 방탈출
 * https://www.acmicpc.net/problem/23743
 */
public class baek23743 {
    static class Node implements Comparable<Node> {
        int s;
        int e;
        int t;

        public Node(int s, int e, int t) {
            this.s = s;
            this.e = e;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }

    static int[] p;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        p = new int[N + 2];
        for (int i = 0; i <= N + 1; i++) {
            p[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            pq.add(new Node(s, e, w));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            pq.add(new Node(N + 1, i, Integer.parseInt(st.nextToken())));
        }
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (find(cur.s) != find(cur.e)) {
                answer += cur.t;
                union(cur.s, cur.e);
            }
        }

        System.out.println(answer);

    }

    static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            p[y] = x;
        }
    }
}
