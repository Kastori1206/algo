package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 서울 지하철 2호선
 * https://www.acmicpc.net/problem/16947
 */
public class baek16947 {
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited, isCycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        isCycle = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dfs(i, i, i)) {
                break;
            }
            isCycle = new boolean[N + 1];
        }
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                answer.append("0 ");
            } else {
                answer.append(String.valueOf(find(i))).append(" ");
            }
        }
        System.out.println(answer.toString());
    }

    private static int find(int v) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N + 1];

        visited[v] = true;
        q.offer(v);

        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (isCycle[cur]) {
                    return res;
                }
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    q.offer(next);
                }
            }
            res++;
        }
        return 0;
    }

    private static boolean dfs(int pre, int cur, int start) {
        isCycle[cur] = true;
        for (int next : adj[cur]) {
            if (!isCycle[next]) {
                if (dfs(cur, next, start)) {
                    return true;
                }
            } else if (next != pre && next == start) {
                return true;
            }
        }
        isCycle[cur] = false;

        return false;
    }
}
