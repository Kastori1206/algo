package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 웜홀
 * https://www.acmicpc.net/problem/1865
 */
public class baek1865 {
    static class Node {
        int s, e, w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N, M, W;
    static final int INF = 987654321;
    static Node[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            adj = new Node[2 * M + W];

            int idx = 0;
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if (i < M) {
                    adj[idx++] = new Node(S, E, T);
                    adj[idx++] = new Node(E, S, T);
                } else {
                    adj[idx++] = new Node(S, E, -T);
                }
            }
            if (bf(1)) {
                answer.append("YES\n");
            } else {
                answer.append("NO\n");
            }
        }
        bw.write(answer.toString());
        br.close();
        bw.close();
    }

    public static boolean bf(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0 ; j < adj.length; j++) {
                Node node = adj[j];
                if (dist[node.s] + node.w < dist[node.e]) {
                    dist[node.e] = dist[node.s] + node.w;
                    if(i==N){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
