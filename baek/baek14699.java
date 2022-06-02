package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 관악산 등산
 * https://www.acmicpc.net/problem/14699
 */
public class baek14699 {
    static int N, M;
    static List<Integer>[] adj;
    static int[] h, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[5001];

        for (int i = 0; i < 5001; i++) {
            adj[i] = new ArrayList<>();
        }
        h = new int[N + 1];
        dp = new int[5001];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (h[a] < h[b]) {
                adj[a].add(b);
            } else {
                adj[b].add(a);
            }
        }
        for (int i = 1; i <= N; i++) {
            answer.append(dfs(i)).append("\n");
        }
        System.out.println(answer);
    }
    static int dfs(int cur) {
        if (dp[cur] != 0) {
            return dp[cur];
        }
        for (int next : adj[cur]) {
            dp[cur] = Math.max(dp[cur], dfs(next));
        }
        return dp[cur] += 1;
    }
}
