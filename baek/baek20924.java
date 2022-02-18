package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 트리의 기둥과 가지
 * https://www.acmicpc.net/problem/20924
 */
public class baek20924 {
    static class Node {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", d=" + d +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<Node>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
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

        long[] answer = new long[2];
        Node giga = null;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(R);
        visited[R] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int res = 0;
            for (Node next : adj[cur]) {
                if (!visited[next.v]) {
                    res++;
                }
                if (res > 1) {
                    break;
                }
            }
            if (res != 1) {
                giga = new Node(cur, 0);
                break;
            }

            for (Node next : adj[cur]) {
                if (visited[next.v]) {
                    continue;
                }
                answer[0] += next.d;
                q.offer(next.v);
                visited[next.v] = true;
            }
        }
        Queue<Node> q2 = new LinkedList<>();

        q2.add(giga);

        while (!q2.isEmpty()) {
            Node node = q2.poll();
            int cur = node.v;
            int d = node.d;
            if (adj[cur].size() == 1) {
                answer[1] = Math.max(answer[1], d);
                continue;
            }

            for (Node next : adj[cur]) {
                if (visited[next.v]) {
                    continue;
                }
                visited[next.v] = true;
                q2.offer(new Node(next.v, next.d + d));
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }
}
