package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 독립집합
 * https://www.acmicpc.net/problem/2213
 */
public class baek2213 {
    static int N;
    static int[][] dp;
    static int[] costs;
    static boolean[] visited;
    static List<Integer>[] adj;
    static List<Integer> path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2];
        costs = new int[N + 1];
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        path = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
        dfs(1);
        visited = new boolean[N + 1];
        getPath(1, 0);
        Collections.sort(path);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
        for (Integer v : path) {
            System.out.print(v + " ");
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;

        dp[cur][0] = 0;
        dp[cur][1] = costs[cur];

        for (Integer next : adj[cur]) {
            if (visited[next]) {
                continue;
            }

            dfs(next);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
        }
    }

    static void getPath(int cur, int pre) {
        if (dp[cur][1] > dp[cur][0] && !visited[pre]) {
            path.add(cur);
            visited[cur] = true;
        }

        for (Integer next : adj[cur]) {
            if (next == pre) {
                continue;
            }
            getPath(next, cur);
        }
    }
}
