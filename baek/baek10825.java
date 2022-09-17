package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 국영수
 * https://www.acmicpc.net/problem/10825
 */
public class baek10825 {
    static class Node implements Comparable<Node> {
        String name;
        int a; //국어
        int b; //영어
        int c; //수학

        public Node(String name, int a, int b, int c) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            if (a == o.a) {
                if (b == o.b) {
                    if (c == o.c) {
                        return name.compareTo(o.name);
                    }
                    return -Integer.compare(c, o.c);
                }
                return Integer.compare(b, o.b);
            }
            return -Integer.compare(a, o.a);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(name, a, b, c));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            sb.append(node.name).append("\n");
        }
        System.out.println(sb);
    }
}
