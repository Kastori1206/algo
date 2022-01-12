package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 진우의 민트초코우유
 * https://www.acmicpc.net/problem/20208
 */
public class baek20208 {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, H, answer;
    static int[][] map;
    static boolean[] visited;
    static Node start;
    static List<Node> mint;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mint = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) {
                    start = new Node(r, c);
                } else if (temp == 2) {
                    mint.add(new Node(r, c));
                }
            }
        }

        visited = new boolean[mint.size()];

        for (int i = 0; i < mint.size(); i++) {
            Node cur = mint.get(i);
            int d = dist(start, cur);

            if (d <= M) {
                dfs(cur, i, M - d + H, 1);
            }
        }
        System.out.println(answer);

    }

    static void dfs(Node cur, int idx, int h, int cnt) {
        visited[idx] = true;
        for (int i = 0; i < mint.size(); i++) {
            if (visited[i]) {
                continue;
            }

            Node next = mint.get(i);
            int d = dist(cur, next);

            if (d <= h) {
                dfs(next, i, h - d + H, cnt + 1);
            }
        }
        if (dist(cur, start) <= h) {
            answer = Math.max(answer, cnt);
        }
        visited[idx] = false;
    }

    static int dist(Node a, Node b) {
        return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
    }
}
