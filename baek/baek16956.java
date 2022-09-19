package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 늑대와 양
 * https://www.acmicpc.net/problem/16956
 */
public class baek16956 {
    static int R, C;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        Queue<int[]> q = new LinkedList<>();

        for (int r = 0; r < R; r++) {
            String input = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'W') {
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] == '.') {
                    map[nr][nc] = 'D';
                } else if (map[nr][nc] == 'S') {
                    System.out.println(0);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(1).append("\n");
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
