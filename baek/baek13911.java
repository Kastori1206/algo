package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 집 구하기
 * https://www.acmicpc.net/problem/13911
 */
public class baek13911 {
    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

    static List<Edge>[] adj;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        pq = new PriorityQueue<>();
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        int[] mac = new int[V + 1];
        Arrays.fill(mac, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int minM = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());
            mac[m] = 0;
            pq.offer(new Edge(m, 0));
        }

        dijkstra(mac);

        int[] star = new int[V + 1];
        Arrays.fill(star, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int minS = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(st.nextToken());
            star[m] = 0;
            pq.offer(new Edge(m, 0));
        }
        dijkstra(star);

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= V; i++) {
            if (mac[i] <= 0 || mac[i] > minM) {
                continue;
            }
            if (star[i] <= 0 || star[i] > minS) {
                continue;
            }
            answer = Math.min(answer, mac[i] + star[i]);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    static void dijkstra(int[] dist) {
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            for (Edge next : adj[cur.v]) {
                int d = cur.w + next.w;
                if (dist[next.v] > d) {
                    pq.offer(new Edge(next.v, d));
                    dist[next.v] = d;
                }
            }
        }
    }
}
