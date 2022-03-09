package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 순열장난
 * https://www.acmicpc.net/problem/10597
 */
public class baek10597 {
    static String kriii;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        kriii = br.readLine();
        visited = new boolean[51];

        dfs(0, 0, "");

    }

    static void dfs(int idx, int n, String res) {
        if (idx == kriii.length()) {
            if (check(n)) {
                System.out.println(res.trim());
                System.exit(0);
            }
            return;
        }
        //한자리수
        int num = kriii.charAt(idx) - '0';
        if (!visited[num]) {
            visited[num] = true;
            dfs(idx + 1, Math.max(n, num), res + " " + num);
            visited[num] = false;
        }
        //두자리수
        if (idx < kriii.length() - 1) {
            num = (kriii.charAt(idx) - '0') * 10 + (kriii.charAt(idx + 1) - '0');
            if (num <= 50 && !visited[num]) {
                visited[num] = true;
                dfs(idx + 2, Math.max(n, num), res + " " + num);
                visited[num] = false;
            }
        }
    }

    private static boolean check(int n) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
