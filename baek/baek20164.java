package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 홀수 홀릭 호석
 * https://www.acmicpc.net/problem/20164
 */
public class baek20164 {
    static int min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(N, 0);
        System.out.println(min + " " + max);
    }

    static void dfs(String num, int res) {
        int len = num.length();
        //홀수의 갯수
        res += getOdd(Integer.parseInt(num));

        //한자리 숫자 일 때
        if (len == 1) {
            min = Math.min(res, min);
            max = Math.max(res, max);
            return;
        }
        //두자리 숫자 일 때
        if (len == 2) {
            int n = (num.charAt(0) - '0') + (num.charAt(1) - '0');
            dfs(Integer.toString(n), res);
            return;
        }

        //세자리 이상
        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String a = num.substring(0, i);
                String b = num.substring(i, j);
                String c = num.substring(j, len);
                int n = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);

                dfs(Integer.toString(n), res);
            }
        }
    }

    static int getOdd(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            if (temp % 2 == 1) {
                res++;
            }
            n /= 10;
        }
        return res;
    }
}
