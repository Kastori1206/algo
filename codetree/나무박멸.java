package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 나무박멸
 * https://www.codetree.ai/frequent-problems/tree-kill-all/description
 */
public class 나무박멸 {
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

    static int n, m, k, c;
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] map;
    static int[][] jmap;

    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        jmap = new int[n][n];


        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            grow();
            burn(i);
            setJechos(getLoc(), i);
        }

        System.out.println(answer);
    }


    static void setJechos(Node start, int year) {
        int rr = start.r;
        int cc = start.c;
        if (rr == -1 && cc == -1) {
            return;
        }
        jmap[rr][cc] = year + c;

        for (int d = 4; d < 8; d++) {
            for (int i = 1; i <= k; i++) {
                int nr = rr + dr[d] * i;
                int nc = cc + dc[d] * i;

                if (!isIn(nr, nc)) {
                    break;
                }
                if (map[nr][nc] == -1) {
                    break;
                }
                if (map[nr][nc] == 0) {
                    jmap[nr][nc] = year + c;
                    break;
                }
                jmap[nr][nc] = year + c;
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (jmap[r][c] < year) {
                    continue;
                }
                answer += map[r][c];
                map[r][c] = 0;
            }
        }
    }

    static Node getLoc() {
        int max = 0;
        Node res = new Node(-1, -1);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] <= 0) {
                    continue;
                }

                int sum = map[r][c];
                for (int d = 4; d < 8; d++) {
                    int nr = r;
                    int nc = c;
                    for (int i = 1; i <= k; i++) {
                        nr += dr[d];
                        nc += dc[d];

                        if (!isIn(nr, nc)) {
                            continue;
                        }
                        if (map[nr][nc] == -1) {
                            break;
                        }
                        if (map[nr][nc] == 0) {
                            sum += map[nr][nc];
                            break;
                        }
                        sum += map[nr][nc];
                    }
                }
                if (max < sum) {
                    res.r = r;
                    res.c = c;
                    max = sum;
                }
            }
        }
        return res;
    }


    static void grow() {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] <= 0) {
                    continue;
                }
                // 주변 나무 갯수 확인
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] > 0) {
                        cnt++;
                    }
                }
                map[r][c] += cnt;
            }
        }
    }

    static void burn(int year) {
        int[][] temp = deepCopy();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (map[r][c] <= 0) {
                    continue;
                }

                int cnt = 0;
                boolean[] check = new boolean[4];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (jmap[nr][nc] >= year) {
                        continue;
                    }
                    if (map[nr][nc] != 0) {
                        continue;
                    }
                    check[d] = true;
                    cnt++;
                }

                for (int d = 0; d < 4; d++) {
                    if (check[d]) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        temp[nr][nc] += map[r][c] / cnt;
                    }
                }
            }
        }
        map = temp;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    private static int[][] deepCopy() {
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, res[i], 0, n);
        }

        return res;
    }

    static void print() {
        System.out.println("=========map===========");
        for (int r = 0; r < n; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
        System.out.println("=========jmap===========");
        for (int r = 0; r < n; r++) {

            System.out.println(Arrays.toString(jmap[r]));
        }
    }
}
