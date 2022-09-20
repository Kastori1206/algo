package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 확장 게임
 * https://www.acmicpc.net/problem/16920
 */
public class baek16920 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, P;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int[] cnt, S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cnt = new int[P + 1];
        S = new int[P + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Node>[] q = new LinkedList[P + 1];
        for (int i = 0; i <= P; i++) {
            q[i] = new LinkedList<>();
        }

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                char ch = input.charAt(c);
                if (ch == '.') {
                    map[r][c] = 0;
                } else if (ch == '#') {
                    map[r][c] = -1;
                } else {
                    map[r][c] = (ch - '0');
                    q[map[r][c]].offer(new Node(r, c));
                    cnt[map[r][c]]++;
                }
            }
        }

        while (true) {
            boolean flag = false;
            for (int i = 1; i <= P; i++) {
                int len = S[i];

                while (!q[i].isEmpty() && len-- > 0) {
                    int qSize = q[i].size();
                    for (int j = 0; j < qSize; j++) {
                        Node cur = q[i].poll();
                        int p = map[cur.r][cur.c];

                        for (int d = 0; d < 4; d++) {
                            int nr = cur.r + dr[d];
                            int nc = cur.c + dc[d];
                            if (!isIn(nr, nc)) {
                                continue;
                            }
                            if (map[nr][nc] != 0) {
                                continue;
                            }
                            q[i].offer(new Node(nr, nc));
                            map[nr][nc] = p;
                            cnt[p]++;
                            flag = true;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= P; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
