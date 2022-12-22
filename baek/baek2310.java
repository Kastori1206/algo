package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 어드벤처 게임
 * https://www.acmicpc.net/problem/2310
 */
public class baek2310 {
    static class Node{
        char ch;
        int w;

        public Node(char ch, int w) {
            this.ch = ch;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", w=" + w +
                    '}';
        }
    }
    static List<Integer>[] adj;
    static Node[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            boolean[][] visited = new boolean[N + 1][N + 1];
            nodes = new Node[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                nodes[i] = new Node(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));

                while (true) {
                    int n = Integer.parseInt(st.nextToken());
                    if (n == 0) {
                        break;
                    }
                    adj[i].add(n);
                }
            }

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{1, calc(nodes[1], 0)});
            String answer = "No";
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                if (cur[0] == N) {
                    answer = "Yes";
                    break;
                }
                for (int next : adj[cur[0]]) {
                    if (visited[cur[0]][next]) {
                        continue;
                    }
                    if (calc(nodes[next], cur[1]) < 0) {
                        continue;
                    }
                    visited[cur[0]][next] = true;
                    q.offer(new int[]{next, calc(nodes[next], cur[1])});
                }

            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);


    }
    static int calc(Node node, int money) {
        switch (node.ch) {
            case 'L':
                return Math.max(money, node.w);
            case 'T':
                return money - node.w;
        }
        return money;
    }
}
