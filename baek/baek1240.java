package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 노드사이의 거리
 * https://www.acmicpc.net/problem/1240
 */
public class baek1240 {
    static class Node {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    static List<Node>[] adj;
    static int N, M;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            dist = new int[N + 1];
            Arrays.fill(dist, -1);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            answer.append(bfs(start, end)).append("\n");
        }

        System.out.println(answer);


    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                break;
            }
            for (Node next : adj[cur]) {
                if (dist[next.v] >= 0) {
                    continue;
                }
                dist[next.v] = dist[cur] + next.d;
                q.offer(next.v);

            }
        }

        return dist[end];
    }
}
