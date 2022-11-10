package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NxM 보드 완주하기
 * https://www.acmicpc.net/problem/9944
 */
public class baek9944 {
    static int N, M, answer, area;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = 1;
        String temp = "";

        while ((temp = br.readLine()) != null) {
            st = new StringTokenizer(temp);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            answer = Integer.MAX_VALUE;
            visited = new boolean[N][M];
            area = 0;

            for (int r = 0; r < N; r++) {
                String input = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = input.charAt(c);
                    if (map[r][c] == '.') {
                        area++;
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == '*') {
                        continue;
                    }
                    for (int d = 0; d < 4; d++) {
                        visited[r][c] = true;
                        dfs(r, c, 1, 1, d);
                        visited[r][c] = false;
                    }

                }
            }
            sb.append("Case ").append(t).append(": ");
            if (area == 1) {
                sb.append(0);
            } else {
                sb.append(answer == Integer.MAX_VALUE ? -1 : answer);
            }
            sb.append("\n");
            t++;
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, int cnt, int res, int dir) {
        if (area == cnt) {
            answer = Math.min(res, answer);
            return;
        }
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        if (isIn(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]) {
            visited[nr][nc] = true;
            dfs(nr, nc, cnt + 1, res, dir);
            visited[nr][nc] = false;
        } else {
            for (int d = 0; d < 4; d++) {
                int nrr = r + dr[d];
                int ncc = c + dc[d];

                if (isIn(nrr, ncc) && map[nrr][ncc] == '.' && !visited[nrr][ncc]) {
                    visited[nrr][ncc] = true;
                    dfs(nrr, ncc, cnt + 1, res + 1, d);
                    visited[nrr][ncc] = false;
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
