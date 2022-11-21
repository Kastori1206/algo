package groom.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
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

        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;


        while (!q.isEmpty()) {
            int cur = q.poll();
            answer++;

            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.offer(next);
            }
        }

        System.out.println(answer);
    }
}
