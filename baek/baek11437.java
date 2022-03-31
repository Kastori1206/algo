package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * LCA
 * https://www.acmicpc.net/problem/11437
 */
public class baek11437 {
    static int[][] p;
    static int[] d;
    static List<Integer>[] adj;
    static boolean[] visited;
    static final int MAX = 20; // 2^19 = 524,288
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        p = new int[N + 1][MAX];
        d = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        setParent();


        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lca2(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    //    static int lca(int a, int b) {
//        while (p[a][1] != p[b][1]) {
//            if (p[a][1] > p[b][1]) {
//                a = p[a][0];
//            } else {
//                b = p[b][0];
//            }
//        }
//
//        while (a != b) {
//            a = p[a][0];
//            b = p[b][0];
//        }
//        return a;
//    }
    static void setParent() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                d[cur] = depth;
                for (int next : adj[cur]) {
                    if (visited[next]) {
                        continue;
                    }
                    p[next][0] = cur;
                    visited[next] = true;
                    q.offer(next);
                }
            }
            depth++;
        }

        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j <= N; j++) {
                p[j][i] = p[p[j][i - 1]][i - 1];
            }
        }
    }

    static int lca2(int a, int b) {
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
