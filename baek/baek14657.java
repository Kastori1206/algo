package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 준오는 최종인재야!!
 * https://www.acmicpc.net/problem/14657
 */
public class baek14657 {
    static class Node{
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    static List<Node>[] adj;
    static int N, T, cnt, sum, root;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        sum = Integer.MAX_VALUE;

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, w));
            adj[b].add(new Node(a, w));
        }

        sum = 0;
        cnt = 1;
        dfs(1, 0, 1);
        visited = new boolean[N + 1];
        dfs(root, 0, 1);
        int answer = sum % T == 0 ? sum / T : sum / T + 1;
        System.out.println(answer);
    }

    static void dfs(int cur, int s, int c) {
        if (cnt < c ) {
            root = cur;
            cnt = c;
            sum = s;
        } else if (cnt == c && sum > s) {
            root = cur;
            sum = s;
        }

        visited[cur] = true;
        for (Node next : adj[cur]) {
            if (visited[next.v]) {
                continue;
            }
            dfs(next.v, s + next.w, c + 1);
        }


    }
}
