package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 전단지 돌리기
 * https://www.acmicpc.net/problem/19542
 */
public class baek19542 {
    static int N, S, D, answer;
    static int[] depth;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        depth = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        dfs(S, -1);
        System.out.println(answer * 2);
    }

    static int dfs(int cur, int pre) {
        for (int next : adj[cur]) {
            if (next != pre) {
                depth[cur] = Math.max(depth[cur], dfs(next, cur) + 1);
            }
        }
        if (cur != S && depth[cur] >= D) {
            answer++;
        }
        return depth[cur];
    }
}
