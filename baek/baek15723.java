package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * n단 논법
 * https://www.acmicpc.net/problem/15723
 */
public class baek15723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] p = new int[26];
        Arrays.fill(p, -1);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = input[0].charAt(0) - 'a';
            int b = input[2].charAt(0) - 'a';

            p[a] = b;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = input[0].charAt(0) - 'a';
            int b = input[2].charAt(0) - 'a';

            while (true) {
                if (a == b || p[a] == -1) {
                    break;
                }
                a = p[a];
            }
            sb.append((a == b ? "T\n" : "F\n"));
        }

        System.out.print(sb);
    }


}
