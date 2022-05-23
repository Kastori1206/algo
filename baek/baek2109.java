package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 순회강연
 * https://www.acmicpc.net/problem/2109
 */
public class baek2109 {
    static class Node implements Comparable<Node> {

        int p, d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return -Integer.compare(this.p, o.p);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        int[] arr = new int[10000 + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(p, d));
        }

        Collections.sort(list);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            Node node = list.get(i);
            for (int j = node.d; j >= 1; j--) {
                if (arr[j] < node.p) {
                    arr[j] = node.p;
                    break;
                }
            }
        }

        for (int i = 0; i < 10001; i++) {
            answer += arr[i];
        }
        System.out.println(answer);
    }
}
