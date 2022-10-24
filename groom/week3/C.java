package groom.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.offer(1);
        visited[1] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if (cur == N) {
                    if (d <= K) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }

                    return;
                }
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    q.offer(next);
                    visited[next] = true;
                }
            }
            d++;
        }
        System.out.println("NO");
    }
}
