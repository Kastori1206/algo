package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 민준이와 마산 그리고 건우
 * https://www.acmicpc.net/problem/18223
 */
public class baek18223 {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<Node>[] adj;
    static int[] dist;
    static int V, E, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        int res1 = dijkstra(1, V);
        int res2 = dijkstra(1, P) + dijkstra(P, V);

        System.out.println(res1 == res2 ? "SAVE HIM" : "GOOD BYE");
    }

    static int dijkstra(int start, int end) {
        int res = 0;
        dist = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.v == end) {
                res = cur.cost;
                break;
            }

            for (Node next : adj[cur.v]) {
                if (cur.cost + next.cost < dist[next.v]) {
                    dist[next.v] = cur.cost + next.cost;
                    pq.offer(new Node(next.v, dist[next.v]));
                }
            }

        }
        return res;
    }
}
