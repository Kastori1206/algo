package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Cubeditor
 * https://www.acmicpc.net/problem/1701
 */
public class baek1701 {
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            getPi(str.substring(i));
        }

        System.out.println(answer);
    }

    static void getPi(String str) {
        int len = str.length();
        int[] p = new int[len];

        int j = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = p[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                p[i] = ++j;
            }
            answer = Math.max(answer, p[i]);
        }
    }

}
