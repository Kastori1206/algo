package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 세부
 * https://www.acmicpc.net/problem/13905
 */
public class baek13905 {
    static class Node implements Comparable<Node> {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return -Integer.compare(w, o.w);
        }
    }

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] adj = new ArrayList[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, w));
            adj[e].add(new Node(s, w));
        }

        boolean[] visited = new boolean[N + 1];
        int[] D = new int[N + 1];
        D[start] = INF;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) {
                continue;
            }
            visited[cur.v] = true;
            for (Node next : adj[cur.v]) {
                int v = next.v;
                int w = next.w;

                D[v] = Math.max(D[v], Math.min(D[cur.v], w));
                pq.offer(next);
            }
        }

        System.out.println(D[end]);
    }

}
