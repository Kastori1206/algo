package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 지름길
 * https://www.acmicpc.net/problem/1446
 */
public class baek1446 {
    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dist = new int[10001];
        Arrays.fill(dist, 987654321);
        dist[D] = D;
        List<Node>[] adj = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (b - a <= w) {
                continue;
            }
            if (b > D) {
                continue;
            }
            adj[a].add(new Node(b, w));
        }

        int pre = -1;
        for (int i = 0; i <= D; i++) {
            if (i != 0) {
                pre = dist[i - 1];
            }
            dist[i] = Math.min(dist[i], pre + 1);

            for (Node next : adj[i]) {
                if (dist[next.v] > dist[i] + next.w) {
                    dist[next.v] = dist[i] + next.w;
                }
            }
        }

        System.out.println(dist[D]);
    }
}
