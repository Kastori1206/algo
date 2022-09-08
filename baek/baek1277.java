package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 발전소 설치
 * https://www.acmicpc.net/problem/1277
 */
public class baek1277 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, W;
    static Node[] edges;
    static double M, INF = 200001;
    static boolean[][] connected;
    static double[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        M = Double.parseDouble(br.readLine());

        edges = new Node[N + 1];
        dist = new double[N + 1];
        connected = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Node(r, c);
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connected[a][b] = true;
            connected[b][a] = true;
        }

        solve();
        System.out.println((long) (dist[N] * 1000));

    }

    static void solve() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (connected[1][i]) {
                dist[i] = 0;
            }
        }

        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            double min = INF;
            int cur = 0;
            for (int j = 1; j <= N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (min < dist[j]) {
                    continue;
                }
                min = dist[j];
                cur = j;
            }
            if (cur == N) {
                break;
            }
            visited[cur] = true;
            for (int next = 1; next <= N; next++) {
                if (next == cur) {
                    continue;
                }
                double d = dist[cur] + getDist(cur, next);
                if (dist[next] > d) {
                    dist[next] = d;
                }
            }
        }
    }

    static double getDist(int cur, int next) {
        if (connected[cur][next]) {
            return 0;
        }
        Node a = edges[cur];
        Node b = edges[next];

        double res = Math.pow(a.r - b.r, 2) + Math.pow(a.c - b.c, 2);
        return Math.sqrt(res);
    }
}
