package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리 조작
 * https://www.acmicpc.net/problem/15684
 */
public class baek15684 {
    static int N, M, H, answer;
    static int[][] map;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            map[r][c + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 0);
            if (flag) {
                break;
            }
        }
        System.out.println(flag ? answer : -1);
    }

    static void dfs(int h, int cnt) {
        if (flag) {
            return;
        }
        if (answer == cnt) {
            if (check()) {
                flag = true;
            }
            return;
        }

        for (int r = h; r < H + 1; r++) {
            for (int c = 1; c < N; c++) {
                if (map[r][c] != 0) {
                    continue;
                }
                if (map[r][c + 1] != 0) {
                    continue;
                }
                map[r][c] = 1;
                map[r][c + 1] = 2;
                dfs(r, cnt + 1);
                map[r][c] = 0;
                map[r][c + 1] = 0;
            }
        }
    }

    static boolean check() {
        for (int c = 1; c <= N; c++) {
            int nc = c;
            int nr = 1;

            for (int r = 0; r < H; r++) {
                if (map[nr][nc] == 1) {
                    nc++;
                } else if (map[nr][nc] == 2) {
                    nc--;
                }
                nr++;
            }
            if (nc != c) {
                return false;
            }
        }
        return true;
    }
}
