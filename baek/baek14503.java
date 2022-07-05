package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 */
public class baek14503 {
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        st = new StringTokenizer(br.readLine());

        answer = 1;
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(startR, startC, dir);
        System.out.println(answer);

    }

    static void dfs(int r, int c, int dir) {
        map[r][c] = 2;

        for (int d = 0; d < 4; d++) {
            dir = turnLeft(dir);
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (map[nr][nc] != 0) {
                continue;
            }

            answer++;
            dfs(nr, nc, dir);
            return;
        }

        int back = getBackDir(dir);
        int nr = r + dr[back];
        int nc = c + dc[back];

        if (isIn(nr, nc) && map[nr][nc] != 1) {
            dfs(nr, nc, dir);
        }
    }

    static int getBackDir(int d) {
        return (d + 2) % 4;
    }

    static int turnLeft(int d) {
        return (d + 3) % 4;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
