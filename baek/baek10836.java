package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 여왕벌
 * https://www.acmicpc.net/problem/10836
 */
public class baek10836 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cnt = new int[M * 2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for (int j = a; j < a + b; j++) {
                cnt[j]++;
            }
            for (int j = a + b; j < a + b + c; j++) {
                cnt[j] += 2;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    System.out.print(1 + cnt[(M - 1) - i] + " ");
                } else {
                    System.out.print(1 + cnt[(M - 1) + j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
