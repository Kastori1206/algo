package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 */
public class baek1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        String[] sub = br.readLine().split("-");

        for (int i = 0; i < sub.length; i++) {
            int sum = 0;
            String[] add = sub[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                sum += Integer.parseInt(add[j]);
            }

            if (answer == Integer.MAX_VALUE) {
                answer = sum;
            } else {
                answer -= sum;
            }
        }
        System.out.println(answer);
    }
}
