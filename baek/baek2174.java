package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 시뮬레이션
 * https://www.acmicpc.net/problem/2174
 */
public class baek2174 {
    static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    //N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int A, B;
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new Node[N];
        int[][] check = new int[B][A];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = getDir(st.nextToken());

            nodes[i] = new Node(x, y, d);
            check[y][x] = i + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            char cmd = st.nextToken().charAt(0);
            int n = Integer.parseInt(st.nextToken());

            if (cmd == 'F') {
                int x = nodes[idx].x;
                int y = nodes[idx].y;

                check[y][x] = 0;

                for (int j = 0; j < n; j++) {
                    int ny = y + dy[nodes[idx].d];
                    int nx = x + dx[nodes[idx].d];

                    if (!isIn(nx, ny)) {
                        System.out.printf("Robot %d crashes into the wall", idx + 1);
                        return;
                    }
                    if (check[ny][nx] != 0) {
                        System.out.printf("Robot %d crashes into robot %d", idx + 1, check[ny][nx]);
                        return;
                    }
                    x = nx;
                    y = ny;
                }
                nodes[idx].x = x;
                nodes[idx].y = y;
                check[y][x] = idx + 1;
            } else {
                nodes[idx].d = getChange(cmd, nodes[idx].d, n);
            }
        }

        System.out.println("OK");
    }

    private static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < A && y < B;
    }

    private static int getChange(char cmd, int d, int n) {
        for (int i = 0; i < n; i++) {
            if (cmd == 'L') {
                d = d == 0 ? 3 : d - 1;
            } else {
                d = (d + 1) % 4;
            }
        }
        return d;
    }

    private static int getDir(String str) {
        switch (str) {
            case "N":
                return 0;
            case "E":
                return 1;
            case "S":
                return 2;
            case "W":
                return 3;
        }
        return -1;
    }
}
