package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 넴모넴모 (Easy)
 * https://www.acmicpc.net/problem/14712
 */
public class baek14712 {
    static int N, M, answer;
    static boolean[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];

        dfs(0);
        System.out.println(answer);

    }

    static void dfs(int cnt) {
        if (cnt == N * M) {
            answer++;
            return;
        }
        int r = cnt / M + 1;
        int c = cnt % M + 1;

        if (map[r - 1][c] && map[r][c - 1] && map[r - 1][c - 1]) {
            dfs(cnt + 1);
        } else {
            dfs(cnt + 1);
            map[r][c] = true;
            dfs(cnt + 1);
            map[r][c] = false;
        }
    }
}
