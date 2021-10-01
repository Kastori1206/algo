package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Σ
 * https://www.acmicpc.net/problem/13172
 */
public class baek13172 {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            long g = gcd(N, S);
            N /= g;
            S /= g;

            answer += (S * pow(N, MOD - 2)) % MOD;
            answer %= MOD;
        }

        System.out.println(answer);


    }

    private static long gcd(long a, long b) {
        long tmp, n;
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
    
    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        long res = pow(a, b / 2);
        if (b % 2 == 0) {
            return (res % MOD * res % MOD) % MOD;
        }
        return (res % MOD * res % MOD * a % MOD) % MOD;
    }
}
