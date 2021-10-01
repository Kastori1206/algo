package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정한 최단 경로
 * https://www.acmicpc.net/problem/1504
 */
public class baek1504 {
    static class Edge implements Comparable<Edge>{
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
    static List<Edge> [] adj;
    static boolean[] visited;
    static int[] dist;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int answer1 = 0;
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, N);

        int answer2 = 0;
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, N);

        System.out.println(answer1 >= INF && answer2 >= INF ? -1 : Math.min(answer1, answer2));

    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.v]) {
                continue;
            }

            visited[cur.v] = true;

            for (Edge next : adj[cur.v]) {
                if (!visited[next.v] && dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }
}

