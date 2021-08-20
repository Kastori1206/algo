package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 피보나치 수 5
 * https://www.acmicpc.net/problem/10870
 */
public class baek10870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));
    }

    public static int fibo(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibo(n-1) + fibo(n - 2);
    }
}
