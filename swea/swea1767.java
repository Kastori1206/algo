package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class swea1767 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] answer;
    static List<int[]> cores;
    static int[][] map;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            answer = new int[2];

            answer[0] = Integer.MIN_VALUE;
            answer[1] = Integer.MAX_VALUE;

            map = new int[N][N];
            cores = new ArrayList<>();

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] == 1) {
                        if (r - 1 < 0 || c - 1 < 0 || r + 1 >= N || c + 1 >= N) {
                            continue;
                        }
                        cores.add(new int[]{r, c});
                    }
                }
            }

            dfs(0, 0, 0);
            sb.append(String.format("#%d %d\n", t, answer[1]));

        }
        System.out.println(sb);
    }

    static void dfs(int idx, int cnt, int len) {
        if (idx == cores.size()) {
            if (answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = len;
            } else if (answer[0] == cnt) {
                answer[1] = Math.min(answer[1], len);
            }
            return;
        }

        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];

        for (int d = 0; d < 4; d++) {
            int lineCnt = getLineCnt(r, c, d);
            changMap(r, c, d, lineCnt, 1);
            if (lineCnt == 0) {
                dfs(idx + 1, cnt, len);
            } else {
                dfs(idx + 1, cnt + 1, len + lineCnt);
                changMap(r, c, d, lineCnt, 0);
            }
        }
    }

    static void changMap(int r, int c, int d, int lineCnt, int line) {
        for (int i = 0; i < lineCnt; i++) {
            r += dr[d];
            c += dc[d];
            map[r][c] = line;
        }
    }

    static int getLineCnt(int r, int c, int d) {
        int res = 0;
        while (true) {
            r = r + dr[d];
            c = c + dc[d];

            if (!isIn(r, c)) {
                break;
            }
            if (map[r][c] == 1) {
                return 0;
            }
            res++;
        }
        return res;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
