package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 택배
 * https://www.acmicpc.net/problem/8980
 */
public class baek8980 {
    static class Node implements Comparable<Node>{
        int s;
        int e;
        int n;

        public Node(int s, int e, int n) {
            this.s = s;
            this.e = e;
            this.n = n;
        }

        @Override
        public int compareTo(Node o) {
            if (e == o.e) {
                return Integer.compare(s, o.s);
            }
            return Integer.compare(e, o.e);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(s, e, n);
        }

        Arrays.sort(nodes, 1, M + 1);

        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = C;
        }

        int answer = 0;

        for (int i = 1; i <= M; i++) {
            Node node = nodes[i];

            int maxBox = Integer.MAX_VALUE;
            for (int j = node.s; j < node.e; j++) {
                maxBox = Math.min(maxBox, w[j]);
            }

            maxBox = Math.min(maxBox, node.n);
            for (int j = node.s; j < node.e; j++) {
                w[j] -= maxBox;
            }
            answer += maxBox;
        }
        System.out.println(answer);
    }
}
