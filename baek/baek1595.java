package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 북쪽나라의 도로
 * https://www.acmicpc.net/problem/1595
 */
public class baek1595 {
    static class Node {
        int v;
        int d;

        public Node(int v, int d) {
            this.v = v;
            this.d = d;
        }
    }

    static List<Node>[] adj = new ArrayList[10001];
    static boolean[] visited = new boolean[10001];
    static int answer, root;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i <= 10000; i++) {
            adj[i] = new ArrayList<>();
        }
        try {
            String input = "";
            while ((input = br.readLine()) != null) {
                st = new StringTokenizer(input);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[a].add(new Node(b, d));
                adj[b].add(new Node(a, d));
            }

        } catch (Exception e) {
        }

        dfs(1, 0);
        answer = 0;

        visited = new boolean[10001];
        dfs(root, 0);

        System.out.println(answer);
    }

    static void dfs(int cur, int res) {
        if (res > answer) {
            answer = res;
            root = cur;
        }
        for (Node next : adj[cur]) {
            if (visited[next.v]) {
                continue;
            }
            visited[next.v] = true;
            dfs(next.v, res + next.d);
        }
    }
}
