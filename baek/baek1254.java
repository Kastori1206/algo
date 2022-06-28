package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 팰린드롬 만들기
 * https://www.acmicpc.net/problem/1254
 */
public class baek1254 {
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        int N = s.length();
        int answer = N;
        for (int i = 0; i < N; i++) {
            if (check(i)) {
                break;
            }
            answer++;
        }
        System.out.println(answer);
    }

    static boolean check(int l) {
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
