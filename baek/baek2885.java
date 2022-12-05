package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 초콜릿 식사
 * https://www.acmicpc.net/problem/2885
 */
public class baek2885 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int D = 1;
        for (int i = 1; i <= 21; i++) {
            if (D == K) {
                System.out.println(D + " " + 0);
                return;
            } else if (D > K) {
                int temp = D;
                int cnt = 0;
                while (true) {
                    if (temp == 0) {
                        break;
                    }
                    if (K % temp == 0) {
                        System.out.println(D + " " +cnt);
                        return;
                    }
                    temp /= 2;
                    cnt++;
                }
            }
            D *= 2;
        }
    }
}
