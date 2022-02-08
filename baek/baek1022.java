package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소용돌이 이쁘게 출력하기
 * https://www.acmicpc.net/problem/1022
 */
public class baek1022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int max = Math.max(Math.max(getValue(r1, c1), getValue(r2, c2)), Math.max(getValue(r1, c2), getValue(r2, c1)));
        int maxLen = 0;
        while (max > 0) {
            maxLen++;
            max /= 10;
        }


        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                System.out.format("%" + maxLen + "d ", getValue(r, c));
            }
            System.out.println();
        }
    }


    static int getValue(int r, int c) {
        int n = Math.max(abs(r), abs(c));
        int val = (2 * n + 1);
        val *= val;

        int diff = 2 * n;
        if (r == n) {
            return val - (n - c);
        }
        val -= diff;
        if (c == -n) {
            return val - (n - r);
        }
        val -= diff;
        if (r == -n) {
            return val - (c + n);
        }
        val -= diff;
        return val - (r + n);
    }

    static int abs(int x) {
        return Math.abs(x);
    }

}

