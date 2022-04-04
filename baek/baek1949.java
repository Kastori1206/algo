package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 우수 마을
 * https://www.acmicpc.net/problem/1949
 */

public class baek1949 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] dist;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        dp = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int cur) {
        visited[cur] = true;

        dp[cur][0] = 0;
        dp[cur][1] = dist[cur];

        for (int next : adj[cur]) {
            if (visited[next]) {
                continue;
            }

            dfs(next);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
    }
}
