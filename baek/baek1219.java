package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 오민식의 고민
 * https://www.acmicpc.net/problem/1219
 */
public class baek1219 {
    static final long INF = Long.MIN_VALUE, GEE = Long.MAX_VALUE;

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N];
        Edge[] edges = new Edge[M];
        int[] money = new int[N];

        Arrays.fill(dist, INF);


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        dist[S] = money[S];

        for (int i = 0; i <= N + 100; i++) {
            for (int j = 0; j < M; j++) {
                int u = edges[j].u;
                int v = edges[j].v;
                int w = edges[j].w;

                if (dist[u] == INF) {
                    continue;
                }
                if (dist[u] == GEE) {
                    dist[v] = GEE;
                } else {
                    long d = dist[u] + money[v] - w;
                    if (dist[v] < d) {
                        dist[v] = d;
                        if (i >= N - 1) {
                            dist[v] = GEE;
                            break;
                        }
                    }
                }
            }
        }
        if (dist[E] == INF) {
            System.out.println("gg");
        } else {
            System.out.println(dist[E] == GEE ? "Gee" : dist[E]);
        }
    }
}
