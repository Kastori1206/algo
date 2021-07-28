package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * MooTube (Silver)
 * https://www.acmicpc.net/problem/15591
 */
public class baek15591 {
    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }

    }

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[N + 1];


        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, r));
            adj[b].add(new Node(a, r));
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];

            Queue<Integer> q = new LinkedList<>();
            q.offer(V);
            visited[V] = true;

            int result = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();

                for (Node next : adj[cur]) {
                    if (visited[next.v]) {
                        continue;
                    }
                    if (next.w < K) {
                        continue;
                    }
                    visited[next.v] = true;
                    q.offer(next.v);
                    result++;
                }
            }
            answer.append(String.valueOf(result)).append("\n");
        }
        System.out.println(answer.toString());
    }
}
