package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백도어
 * https://www.acmicpc.net/problem/17396
 */
public class baek17396 {
    static class Node implements Comparable<Node> {
        int v;
        long d;

        public Node(int v, long d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.d, o.d);
        }
    }

    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N];
        long[] dist = new long[N];
        List<Node>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = INF;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visited[i] = Integer.parseInt(st.nextToken()) == 1 && i != N - 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;

            if (cur.v == N - 1) {
                System.out.println(cur.d);
                return;
            }
            for (Node next : adj[cur.v]) {
                int v = next.v;
                long d = next.d;

                if (dist[v] > dist[cur.v] + d) {
                    dist[v] = dist[cur.v] + d;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        System.out.println(-1);
    }
}
