package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 양
 * https://www.acmicpc.net/problem/3184
 */
public class baek3184 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String temp = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = temp.charAt(c);
            }
        }

        int[] answer = new int[2];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visited[r][c]) {
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{r, c});
                visited[r][c] = true;
                int sheep = 0, wolf = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();

                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];

                        if (!isIn(nr, nc)) {
                            continue;
                        }
                        if (visited[nr][nc]) {
                            continue;
                        }
                        if (map[nr][nc] == '#') {
                            continue;
                        }
                        if (map[nr][nc] == 'o') {
                            sheep++;
                        }
                        if (map[nr][nc] == 'v') {
                            wolf++;
                        }
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }//while
                if (wolf < sheep) {
                    answer[0] += sheep;
                } else {
                    answer[1] += wolf;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }

    public static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
