package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 스크루지 민호
 * https://www.acmicpc.net/problem/12896
 */
public class baek12896 {
    static int answer, root;
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }
        dfs(1, 0);
        visited = new boolean[N + 1];
        answer = 0;
        dfs(root, 0);

        System.out.println(answer % 2 == 0 ? answer / 2 : answer / 2 + 1);
    }

    static void dfs(int cur, int d) {
        if (answer < d) {
            root = cur;
            answer = d;
        }
        for (Integer next : adj[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            dfs(next, d + 1);
        }
    }
}
