package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팩토리얼
 * https://www.acmicpc.net/problem/10872
 */
public class baek10872 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(go(N));
    }

    private static long go(long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        return n * go(n - 1);
    }
}
