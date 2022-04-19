package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek2644 {
    static int start, end, answer;
    static boolean[] visited;
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        answer = -1;
        dfs(start, 0);
        System.out.println(answer);
    }

    static void dfs(int cur, int cnt) {
        visited[cur] = true;
        for (int next : adj[cur]) {
            if (next == end) {
                answer = cnt + 1;
                return;
            }

            dfs(next, cnt + 1);
        }
    }
}



