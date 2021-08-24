package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 합승 택시 요금
 * https://programmers.co.kr/learn/courses/30/lessons/72413
 */
public class 합승택시요금 {
    static List<Edge>[] adj;
    public static void main(String[] args) {
        int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22},
                {1, 6, 25}};
        System.out.println(solution(6,4,6,2,fares));
    }

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int x = fare[0];
            int y = fare[1];
            int w = fare[2];

            adj[x].add(new Edge(y, w));
            adj[y].add(new Edge(x, w));
        }

        int[] distA = dijkstra(a,new int[n + 1]);
        int[] distB = dijkstra(b,new int[n + 1]);
        int[] distS = dijkstra(s,new int[n + 1]);

        for(int i = 1; i<=n;i++){
            answer = Math.min(answer, distA[i] + distB[i] + distS[i]);
        }
        return answer;
    }

    static int[] dijkstra(int start, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.w > dist[cur.v]) {
                continue;
            }
            for (Edge next : adj[cur.v]) {
                int w = dist[cur.v] + next.w;

                if (w < dist[next.v]) {
                    dist[next.v] = w;
                    pq.offer(new Edge(next.v, w));
                }
            }
        }

        return dist;
    }

}

