package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A와 B 2
 * https://www.acmicpc.net/problem/12919
 */
public class baek12919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(dfs(br.readLine(), br.readLine()));
    }

    static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }
        int answer = 0;
        if (t.charAt(0) == 'B') {
            StringBuilder temp = new StringBuilder(t.substring(1));
            answer += dfs(s, temp.reverse().toString());
        }

        if (t.charAt(t.length() - 1) == 'A') {
            answer += dfs(s, t.substring(0, t.length() - 1));
        }

        return answer > 0 ? 1 : 0;
    }
}
