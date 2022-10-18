package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 케빈 베이컨의 단계 법칙
 * https://www.acmicpc.net/problem/1389
 */
public class baek1389 {
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

            adj[a].add(b);
            adj[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int res = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];

            q.offer(i);
            visited[i] = true;

            int depth = 0;
            while (!q.isEmpty()) {
                depth++;
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int cur = q.poll();

                    for (Integer next : adj[cur]) {
                        if (visited[next]) {
                            continue;
                        }
                        visited[next] = true;
                        q.offer(next);
                        res += depth;
                    }
                }
            }

            if (min > res) {
                answer = i;
                min = res;
            }
        }

        System.out.println(answer);
    }
}
