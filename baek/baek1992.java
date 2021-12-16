package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 쿼드트리
 * https://www.acmicpc.net/problem/1992
 */
public class baek1992 {
    static char[][] map;
    static int N;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, N);
        System.out.println(answer.toString());
    }

    /**
     *
     * @param sr        시작 r
     * @param sc        시작 c
     * @param size      크기
     */
    static void dfs(int sr, int sc, int size) {
        if (size == 1 || check(sr, sc, size)) {
            answer.append(map[sr][sc]);
            return;
        }
        size /= 2;

        answer.append("(");
        //왼쪽 위
        dfs(sr, sc, size);
        //오른쪽 위
        dfs(sr, sc + size, size);
        //왼쪽 아래
        dfs(sr + size, sc, size);
        //오른쪽 아래
        dfs(sr + size, sc + size, size);
        answer.append(")");

    }

    //범위 안의 숫자가 모두 0이나 1이면 true, 아니면 false
    private static boolean check(int sr, int sc, int size) {
        char ch = map[sr][sc];
        for (int r = sr; r < sr + size; r++) {
            for (int c = sc; c < sc + size; c++) {
                if (ch != map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

}
