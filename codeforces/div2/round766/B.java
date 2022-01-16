package codeforces.div2.round766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * B. Not Sitting
 * https://codeforces.com/contest/1627/problem/B
 */
public class B {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[N][M];
            int r = N / 2;
            int c = M / 2;
            if (N % 2 == 0) {
                if (M % 2 == 0) {
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            if (!isIn(r + i - 1, c + j - 1)) {
                                continue;
                            }
                            q.offer(new int[]{r + i - 1, c + j - 1});
                            visited[r + i - 1][c + j - 1] = true;
                        }
                    }
                } else {
                    for (int i = 0; i < 2; i++) {
                        if (!isIn(r + i - 1, c)) {
                            continue;
                        }
                        q.offer(new int[]{r + i - 1, c});
                        visited[r + i - 1][c] = true;
                    }
                }
            } else {
                if (M % 2 == 0) {
                    for (int i = 0; i < 2; i++) {
                        if (!isIn(r, c + i - 1)) {

                            continue;
                        }
                        q.offer(new int[]{r, c + i - 1});
                        visited[r][c + i - 1] = true;
                    }
                } else {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int res = getMax(cur[0], cur[1]);
                answer.append(res).append(" ");

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    static int getMax(int r, int c) {
        int max = -1;

        max = Math.max(max, dist(0, 0, r, c));
        max = Math.max(max, dist(N - 1, 0, r, c));
        max = Math.max(max, dist(0, M - 1, r, c));
        max = Math.max(max, dist(N - 1, M - 1, r, c));

        return max;
    }

    static int dist(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
