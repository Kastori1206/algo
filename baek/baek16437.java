package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 양 구출 작전
 * https://www.acmicpc.net/problem/16437
 */
public class baek16437 {
    static long[] dp;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        dp = new long[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            adj[p].add(i);
            if (t == 'W') {
                a *= -1;
            }
            dp[i] = a;
        }

        dfs(1, -1);
        System.out.println(dp[1]);

    }

    static void dfs(int cur, int p) {
        for (int next : adj[cur]) {
            dfs(next, cur);
        }
        if (p != -1) {
            if (dp[cur] > 0) {
                dp[p] += dp[cur];
            }
        }
    }
}
