package groom.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String password = br.readLine();
        char[] alpa = new char[26];

        for (int i = 0; i < 26; i++) {
            alpa[i] = (char)('a' + i);
        }

        for (int i = 0; i < N; i += 2) {
            char p = password.charAt(i);
            int n = password.charAt(i + 1) - '0';

            int a = ((n % 26) * (n % 26)) % 26;
            int b = p - 'a';
            b = (b + a) % 26;
            answer.append(alpa[b]);
        }
        System.out.println(answer);
    }
}
