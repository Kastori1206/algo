package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 십자가 2개 놓기
 * https://www.acmicpc.net/problem/17085
 */
public class baek17085 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static int N, M;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Node> list;
    static boolean[][] visited;
    static char[][] test;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == '#') {
                    list.add(new Node(r, c));
                }
            }
        }
        int answer = -1;
        for (int i = 0; i < list.size(); i++) {
            visited = new boolean[N][M];
            Node node1 = list.get(i);

            for (int k = 0; k <= 7; k++) {
                boolean flag = true;
                for (int d = 0; d < 4; d++) {
                    int nr = node1.r + dr[d] * k;
                    int nc = node1.c + dc[d] * k;

                    if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] != '#') {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                marking(node1, k);
                for (int j = i + 1; j < list.size(); j++) {
                    Node node2 = list.get(j);
                    int size2 = getSize(node2);
                    answer = Math.max(answer, (k * 4 + 1) * (size2 * 4 + 1));
                }
            }
        }

        System.out.println(answer);
    }

    private static int getSize(Node node) {
        int size = Math.min(Math.min(node.r, N - node.r - 1), Math.min(node.c, M - node.c - 1));
        for (int i = 1; i <= size; i++) {
            for (int d = 0; d < 4; d++) {
                int nr = node.r + dr[d] * i;
                int nc = node.c + dc[d] * i;

                if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] != '#') {
                    return i - 1;
                }
            }
        }
        return size;
    }

    static void marking(Node start, int dist) {
        for (int d = 0; d < 4; d++) {
            int nr = start.r + dr[d] * dist;
            int nc = start.c + dc[d] * dist;

            visited[nr][nc] = true;
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
