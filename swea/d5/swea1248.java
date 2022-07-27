package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1248. [S/W 문제해결 응용] 3일차 - 공통조상
 */
public class swea1248 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[][] p;
    static int[] d, cnt;
    static final int MAX = 14; // 2 ^ 14 = 16,384

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            p = new int[V + 1][MAX];
            d = new int[V + 1];
            cnt = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                adj[parent].add(child);
                adj[child].add(parent);
            }

            dfs(1, 0);
            for (int i = 1; i < MAX; i++) {
                for (int j = 1; j < V + 1; j++) {
                    p[j][i] = p[p[j][i - 1]][i - 1];
                }
            }
            System.out.println(Arrays.toString(cnt));
            int root = lca(a, b);

            sb.append(String.format("#%d %d %d\n", t, root, cnt[root]+1));
        }
        System.out.println(sb);
    }
    static int dfs(int cur, int depth) {
        cnt[cur] = 0;
        visited[cur] = true;
        d[cur] = depth;

        for (int next : adj[cur]) {
            if (visited[next]) {
                continue;
            }
            p[next][0] = cur;
            cnt[cur] += dfs(next, depth + 1) + 1;
        }

        return cnt[cur];
    }
    static int lca(int a, int b) {
        if (d[a] > d[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = MAX - 1; i >= 0; i--) {
            if (d[b] - d[a] >= (1 << i)) {
                b = p[b][i];
            }
        }

        if (a == b) {
            return a;
        }
        for (int i = MAX - 1; i >= 0; i--) {
            if (p[a][i] != p[b][i]) {
                a = p[a][i];
                b = p[b][i];
            }
        }
        return p[a][0];
    }

}
