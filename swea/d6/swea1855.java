package swea.d6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * swea1855. 영준이의 진짜 BFS
 */
public class swea1855 {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[][] p;
    static int[] d;
    static List<Integer> list;
    static final int MAX = 21; // 2 ^ 20 = 1,048,576

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            adj = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            p = new int[N + 1][MAX];
            d = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= N; i++) {
                int input = Integer.parseInt(st.nextToken());
                adj[input].add(i);
                adj[i].add(input);
            }

            bfs();
            for (int i = 1; i < MAX; i++) {
                for (int j = 1; j < N + 1; j++) {
                    p[j][i] = p[p[j][i - 1]][i - 1];
                }
            }
            long answer = 0;
            for (int i = 0; i < N-1; i++) {
                int LCA = lca(list.get(i), list.get(i + 1));
                long a = d[list.get(i)] - d[LCA];
                long b = d[list.get(i+1)] - d[LCA];;

                answer += a;
                answer += b;
            }
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
    static void bfs(){
        list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                d[cur] = depth;
                list.add(cur);
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    q.offer(next);
                    p[next][0] = cur;
                    visited[next] = true;
                }
            }
            depth++;
        }
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
