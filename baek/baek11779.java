package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소비용 구하기 2
 * https://www.acmicpc.net/problem/11779
 */
public class baek11779 {
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
    static boolean[] visited;
    static int[] dist, p;
    static final int INF = 200000000;
    static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        dist = new int[N + 1];
        p = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, INF);
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(b, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        answer.append(dijkstra(start, end)).append("\n");

        List<Integer> route = new ArrayList<>();
        int idx = end;

        while (idx != 0) {
            route.add(idx);
            idx = p[idx];
        }

        int size = route.size();
        answer.append(size).append("\n");

        for (int i = size - 1; i >= 0; i--) {
            answer.append(route.get(i) + " ");
        }

        System.out.println(answer.toString());
    }

    public static int dijkstra(int start, int end) {
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
                    p[next.v] = cur.v;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }

        return dist[end];
    }
}

