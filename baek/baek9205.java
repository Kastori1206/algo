package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 맥주 마시면서 걸어가기
 * https://www.acmicpc.net/problem/9205
 */
public class baek9205 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Integer>[] adj;
        Node[] conveniences;
        boolean[] visited;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            conveniences = new Node[N + 2];
            visited = new boolean[N + 2];
            adj = new ArrayList[N + 2];
            for (int i = 0; i < N + 2; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                conveniences[i] = new Node(x, y);
            }

            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    int d = getDist(conveniences[i], conveniences[j]);

                    if (!check(d)) {
                        continue;
                    }
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }

            boolean answer = false;

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            visited[0] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();

                if (cur == N + 1) {
                    answer = true;
                    break;
                }
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    q.offer(next);
                    visited[next] = true;
                }
            }
            sb.append(answer ? "happy" : "sad").append("\n");
        }
        System.out.println(sb);
    }

    static int getDist(Node a, Node b) {
        return (Math.abs(a.x - b.x) + Math.abs(a.y - b.y));
    }

    static boolean check(int d) {
        return d <= (20 * 50);
    }

}
