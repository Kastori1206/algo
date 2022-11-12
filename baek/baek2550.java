package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 전구
 * https://www.acmicpc.net/problem/2550
 */
public class baek2550 {
    static class Node {
        int n;
        int idx;

        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }

    static int N;
    static List<Integer> list;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] left = new int[N];
        int[] right = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            left[i] = n;
            map.put(n, i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            right[i] = map.get(Integer.parseInt(st.nextToken()));
        }

        nodes = new Node[N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) < right[i]) {
                list.add(right[i]);
                nodes[i] = new Node(right[i], list.size() - 1);
            } else {
                int idx = birnary(right[i]);
                list.set(idx, right[i]);
                nodes[i] = new Node(right[i], idx);
            }
        }

        int idx = list.size() - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (nodes[i].idx == idx) {
                list.set(idx--, left[nodes[i].n]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (int n : list) {
            sb.append(n + " ");
        }
        System.out.println(sb);
    }

    private static int birnary(int target) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (list.get(m) < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
