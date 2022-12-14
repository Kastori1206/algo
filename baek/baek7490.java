package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 0 만들기
 * https://www.acmicpc.net/problem/7490
 */
public class baek7490 {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, 0, 1, "1");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int num, int sum, int op, String str) {
        if (idx == N) {
            sum += (num * op);
            if (sum == 0) {
                sb.append(str).append("\n");
            }
            return;
        }

        dfs(idx + 1, num * 10 + (idx + 1), sum, op, str + " " + (idx + 1));
        dfs(idx + 1, idx + 1, sum + (num * op), 1, str + "+" + (idx + 1));
        dfs(idx + 1, idx + 1, sum + (num * op), -1, str + "-" + (idx + 1));
    }
}
