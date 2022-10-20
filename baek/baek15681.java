package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리와 쿼리
 * https://www.acmicpc.net/problem/15681
 */
public class baek15681 {
    static int[] dp;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(R);

        for (int i = 0; i < Q; i++) {
            int v = Integer.parseInt(br.readLine());
            sb.append(dp[v]).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(int cur) {
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dp[cur] += dfs(next);
        }
        return dp[cur];
    }
}
