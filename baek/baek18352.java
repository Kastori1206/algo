package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 특정 거리의 도시 찾기
 * https://www.acmicpc.net/problem/18352
 */
public class baek18352 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }
        // X에서 부터 거리 구하기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dist[X] = 0;
        pq.offer(X);

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int next : adj[cur]) {
                if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    pq.offer(next);
                }
            }
        }

        // 거리가 K인 정점 구하기
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                answer.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        if (answer.size() == 0) {
            sb.append(-1);
        } else {
            for (int i : answer) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
