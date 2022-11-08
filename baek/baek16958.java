package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 텔레포트
 * https://www.acmicpc.net/problem/16958
 */
public class baek16958 {
    static class Node {
        int r;
        int c;
        boolean s;

        public Node(int r, int c, boolean s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static Node[] nodes;
    static int N, T;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean s = Integer.parseInt(st.nextToken()) == 1;
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(r, c, s);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Node start = nodes[Integer.parseInt(st.nextToken())];
            Node end = nodes[Integer.parseInt(st.nextToken())];

            int d = 0;

            if (start.s && end.s) {
                d = getDist(start, end);
            } else if (start.s) {
                int tel = getNearTel(end);
                d = Math.min(tel + T, getDist(start, end));
            } else if (end.s) {
                int tel = getNearTel(start);
                d = Math.min(tel + T, getDist(start, end));
            } else {
                int tel1 = getNearTel(start);
                int tel2 = getNearTel(end);
                d = Math.min(tel1 + tel2 + T, getDist(start, end));
            }
            sb.append(d).append("\n");
        }
        System.out.println(sb);
    }

    private static int getNearTel(Node cur) {
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            Node node = nodes[i];
            if (!node.s) {
                continue;
            }
            int d = getDist(cur, node);
            res = Math.min(res, d);
        }
        return res;
    }

    static int getDist(Node start, Node end) {
        int dist = Math.abs(start.r - end.r) + Math.abs(start.c - end.c);

        if (start.s && end.s) {
            return Math.min(dist, T);
        }
        return dist;
    }
}
