package groom.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    static List<Integer>[] adj;
    static int N, M, K;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }
        int[] d = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(K);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (d[next] != 0) {
                    continue;
                }
                d[next] = d[cur] + 1;
                q.offer(next);
                if (next == K) {
                    System.out.println(d[K]);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}
