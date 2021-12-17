package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 투에-모스 문자열
 * https://www.acmicpc.net/problem/18222
 */
public class baek18222 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        System.out.println(dfs(k - 1));
    }

    /**
     * f(0) = 0
     * f(2n) = f(n)
     * f(2n+1) = 1 - f(n)
     */
    static long dfs(long x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x % 2 == 1) {
            return 1 - dfs(x / 2);
        } else {
            return dfs(x / 2);
        }
    }
}
