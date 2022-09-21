package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 배달
 * https://www.acmicpc.net/problem/1175
 */
public class baek1175 {
    static class Node {
        int r;
        int c;
        int d;
        int s;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int d, int s) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static int[][][][] check;
    static int N, M;
    static Node S, C, E;
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
        input(br);

        System.out.println(bfs());
    }


    private static void init() {
        q = new LinkedList<>();
        map = new char[N][M];
        check = new int[N][M][4][4];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int d = 0; d < 4; d++) {
                    Arrays.fill(check[r][c][d], -1);
                }
            }
        }
    }

    static int bfs() {
        for (int i = 0; i < 4; i++) {
            q.offer(new Node(S.r, S.c, i, 0));
            check[S.r][S.c][i][0] = 0;
        }

        boolean flag = false;
        out:
        while (!q.isEmpty()) {
            Node cur = q.poll();

            int s = cur.s;
            for (int d = 0; d < 4; d++) {
                if (d == cur.d) {
                    continue;
                }
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] == '#') {
                    continue;
                }
                if (check[nr][nc][d][cur.s] != -1) {
                    continue;
                }
                int ns = s;
                if (map[nr][nc] == 'C') {
                    if (nr == C.r && nc == C.c) {  //1번 C방문
                        ns |= 1;
                    } else {                        //2번 C방문
                        ns |= 2;
                    }

                    if (ns == 3) { //C를 두곳다 방문했을 때
                        E = new Node(nr, nc);
                        flag = true;
                    }
                }
                check[nr][nc][d][ns] = check[cur.r][cur.c][cur.d][cur.s] + 1;
                q.offer(new Node(nr, nc, d, ns));
                if (flag) {
                    break out;
                }
            }
        }
        if (!flag) {
            return -1;
        } else {
            return getAnswer();
        }
    }

    private static int getAnswer() {
        int answer = 0;
        for (int d = 0; d < 4; d++) {
            for (int s = 0; s < 4; s++) {
                answer = Math.max(answer, check[E.r][E.c][d][s]);
            }
        }
        return answer;
    }

    private static void input(BufferedReader br) throws IOException {
        for (int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 'S') {
                    S = new Node(r, c);
                } else if (map[r][c] == 'C') {
                    C = new Node(r, c);
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
