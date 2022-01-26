package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 두 번째 트리의 지름
 * https://www.acmicpc.net/problem/19581
 */
public class baek19581 {
    static class Node{
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }
    static int N;
    static List<Node>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, d));
            adj[b].add(new Node(a, d));
        }

        Node end1 = bfs(1, 0);
        int a = end1.v;
        Node end2 = bfs(a, 0);
        int b = end2.v;
        int dist1 = bfs(a, b).d;
        int dist2 = bfs(b, a).d;

        System.out.println(Math.max(dist1, dist2));
    }

    static Node bfs(int s, int rmv) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[rmv] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;
            for (Node node : adj[cur]) {
                int next = node.v;
                int d = node.d;
                if (visited[next]) {
                    continue;
                }
                q.offer(next);
                dist[next] = dist[cur] + d;
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i <= N; i++) {
            if (dist[i] > max) {
                max = dist[i];
                idx = i;
            }
        }
        return new Node(idx, max);
    }
}


