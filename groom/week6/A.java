package groom.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        for (int t = 0; t < 5; t++) {
            String input = br.readLine();
            long a = 0;
            for (int i = 0; i < 7; i += 2) {
                a += input.charAt(i) - '0';
            }

            for (int i = 1; i < 7; i += 2) {
                int temp = input.charAt(i) - '0';
                if (temp == 0) {
                    continue;
                }

                a *= temp;
            }
            answer.append(a % 10).append("\n");
        }
        System.out.println(answer);
    }
}
