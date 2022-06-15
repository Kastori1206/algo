package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ZOAC
 * https://www.acmicpc.net/problem/16719
 */
public class baek16719 {
    static String str;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        str = br.readLine();
        visited = new boolean[str.length()];

        dfs(0, str.length() - 1);
        System.out.println(sb);
    }

    static void dfs(int s, int e) {
        if (s > e) {
            return;
        }
        int idx = s;
        for (int i = s; i <= e; i++) {
            if (str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append('\n');

        dfs(idx + 1, e);
        dfs(s, idx - 1);
    }
}
