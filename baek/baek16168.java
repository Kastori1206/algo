package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 퍼레이드
 * https://www.acmicpc.net/problem/16168
 */
public class baek16168 {
    static int V, E;
    static int[][] visited;
    static List<Integer>[] adj;
    static String answer = "NO";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V + 1];
        visited = new int[V + 1][V + 1];

        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 1; i <= V; i++) {
            if (answer.equals("YES")) {
                break;
            }
            dfs(i, i, 0);
        }
        System.out.println(answer);

    }

    static void dfs(int cur, int num, int cnt) {
        if (cnt == E) {
            answer = "YES";
            return;
        }

        for (int next : adj[cur]) {
            if (visited[cur][next] == num || visited[next][cur] == num) {
                continue;
            }
            visited[cur][next] = visited[next][cur] = num;
            dfs(next, num, cnt + 1);
        }
    }
}
