package codeforces.div3.round820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A. Two Elevators
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int x = Math.abs(b - c) + Math.abs(c - 1);
            int y = Math.abs(a - 1);

            if (x > y) {
                System.out.println(1);
            } else if (x < y) {
                System.out.println(2);
            } else {
                System.out.println(3);
            }
        }
    }
}
