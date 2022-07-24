package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1868. 파핑파핑 지뢰찾기
 */
public class swea1868 {
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
    static int N;
    static char[][] map;
    static List<int[]> mines;
    static int[][] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new char[N][N];
            cnt = new int[N][N];
            mines = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                map[r] = br.readLine().toCharArray();
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == '*') {
                        mines.add(new int[]{r, c});
                    }
                }
            }

            for (int i = 0; i < mines.size(); i++) {
                int r = mines.get(i)[0];
                int c = mines.get(i)[1];

                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == '*') {
                        continue;
                    }
                    cnt[nr][nc]++;
                }
            }

            int answer = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] !='*' && cnt[r][c] == 0) {
                        bfs(r, c);
                        answer++;
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (cnt[r][c] > 0 && map[r][c] != '*') {
                        answer++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", t, answer));


        }
        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        cnt[r][c] = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (cnt[nr][nc] == -1) {
                    continue;
                }
                if (map[nr][nc] == '*') {
                    continue;
                }
                if (cnt[nr][nc] == 0) {
                    q.offer(new int[]{nr, nc});
                }
                cnt[nr][nc] = -1;
            }
        }
    }
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
