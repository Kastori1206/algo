package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */
public class baek11725 {
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }

        dfs(1);
        StringBuilder answer = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            answer.append(parent[i]).append("\n");
        }

        System.out.println(answer.toString());
    }

    public static void dfs(int v) {
        visited[v] = true;
        for (Integer next : adj[v]) {
            if (visited[next]) {
                continue;
            }

            parent[next] = v;
            dfs(next);
        }
    }
}
