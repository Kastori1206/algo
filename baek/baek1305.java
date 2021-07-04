package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 광고
 * https://www.acmicpc.net/problem/1305
 */
public class baek1305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] pi = getPi(S);
        System.out.println(L - pi[L - 1]);
    }

    public static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];

        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
