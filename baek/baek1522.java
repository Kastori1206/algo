package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열 교환
 * https://www.acmicpc.net/problem/1522
 */
public class baek1522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int answer = Integer.MAX_VALUE;

        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            a = str.charAt(i) == 'a' ? a + 1 : a;
        }

        for (int i = 0; i < str.length(); i++) {
            int b = 0;
            for (int j = i; j < i + a; j++) {
                int idx = j % str.length();
                b = str.charAt(idx) == 'b' ? b + 1 : b;
            }
            answer = Math.min(answer, b);
        }
        System.out.println(answer);
    }
}


/*
abababababababa
abbbababaaababa
abbbbbabaaaaaba
abbbbbbbaaaaaaa

*/
