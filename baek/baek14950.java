package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 정복자
 * https://www.acmicpc.net/problem/14950
 */
public class baek14950 {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int val;

        public Edge(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return val - o.val;
        }
    }
    static int[] p, rank;
    static Edge[] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        p = new int[N + 1];
        rank = new int[N + 1];
        edges = new Edge[M];

        for (int i = 0; i <= N; i++) {
            p[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, val);
        }

        Arrays.sort(edges);

        long answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            int a = edge.from;
            int b = edge.to;
            if (find(a) == find(b)) {
                continue;
            }
            union(a, b);
            answer += edge.val + (cnt * t);
            cnt++;
        }
        System.out.println(answer);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (rank[a] < rank[b]) {
                p[a] = b;
            } else {
                p[b] = a;
                if (rank[a] == rank[b]) {
                    rank[a]++;
                }
            }
        }
    }
    static int find(int x) {
        if (x == p[x]) {
            return x;
        }
        return p[x] = find(p[x]);
    }
}
