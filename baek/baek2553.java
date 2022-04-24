package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 마지막 팩토리얼 수
 * https://www.acmicpc.net/problem/2553
 */
public class baek2553 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 1;
        for (int i = 1; i <= N; i++) {
            answer *= i;
            answer %= 1000000000;
            while (answer % 10 == 0) {
                answer /= 10;
            }
        }
        System.out.println(answer % 10);
    }
}
