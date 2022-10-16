package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이 만들기
 * https://www.acmicpc.net/problem/2630
 */
public class baek2630 {
    static int N, w, b;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);
        System.out.println(w);
        System.out.println(b);
    }

    private static void dfs(int sr, int sc, int size) {
        if (size == 1 || check(sr, sc, size)) {
            if (map[sr][sc] == 0) {
                w++;
            } else {
                b++;
            }
            return;
        }

        size /= 2;
        dfs(sr, sc, size);
        dfs(sr + size, sc, size);
        dfs(sr, sc + size, size);
        dfs(sr + size, sc + size, size);
    }

    private static boolean check(int sr, int sc, int size) {
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                if(map[r][c] != map[sr][sc]){
                    return false;
                }
            }
        }
        return true;
    }
}
