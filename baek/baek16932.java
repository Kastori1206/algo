package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 모양 만들기
 * https://www.acmicpc.net/problem/16932
 */
public class baek16932 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        cnt = new int[1000001];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    continue;
                }
                if (visited[r][c]) {
                    continue;
                }
                cnt[idx] = dfs(r, c, idx);
                idx++;
            }
        }
        int answer = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) {
                    continue;
                }
                int temp = 0;
                Set<Integer> set = new HashSet<>();
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (map[nr][nc] == 0) {
                        continue;
                    }
                    set.add(map[nr][nc]);
                }
                for (Integer i : set) {
                    temp += cnt[i];
                }
                answer = Math.max(temp, answer);
            }
        }
        System.out.println(answer+1);
    }

    static int dfs(int r, int c, int k) {
        visited[r][c] = true;
        map[r][c] = k;
        int ret = 1;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (!isIn(nr, nc)) {
                continue;
            }
            if (map[nr][nc] == 0) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }
            ret += dfs(nr, nc, k);
        }
        return ret;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
