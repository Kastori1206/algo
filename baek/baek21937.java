package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작업
 * https://www.acmicpc.net/problem/21937
 */
public class baek21937 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[b].add(a);
        }

        int x = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        int answer = 0;

        //BFS
        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        visited[x] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.offer(next);
                answer++;
            }

        }
        System.out.println(answer);


    }
}
