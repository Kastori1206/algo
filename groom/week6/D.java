package groom.week6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[1000 + 2][1000 + 2];

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for (int r = r1; r < r2; r++) {
                map[r][c1]++;
                map[r][c2]--;
            }
        }

        int answer = 0;
        for (int r = 0; r <= 1000; r++) {
            int a = 0;
            for (int c = 0; c <= 1000; c++) {
                a += map[r][c];
                if (a == K) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
