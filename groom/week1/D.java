package groom.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 소수 찾기
 */
public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = 100000;

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[1] = isPrime[0] = false;

        for (int i = 2; i * i <= max; i++) {
            for (int j = i * i; j <= max; j += i) {
                isPrime[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime[i]) {
                answer += num;
            }
        }

        System.out.println(answer);
    }
}
