package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 버블 소트
 * https://www.acmicpc.net/problem/1377
 */

public class baek1377 {
    static class Node implements Comparable<Node> {
        int n;
        int idx;

        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(n, o.n);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arr, 1, N + 1);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, arr[i].idx - i);
        }

        System.out.println(max + 1);
    }
}
