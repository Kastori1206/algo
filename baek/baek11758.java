package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * CCW
 * https://www.acmicpc.net/problem/11758
 */
public class baek11758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] p = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        int a = (p[0][0] * p[1][1]) + (p[1][0] * p[2][1]) + (p[2][0] * p[0][1]);
        int b = (p[0][1] * p[1][0]) + (p[1][1] * p[2][0]) + (p[2][1] * p[0][0]);

        if (a - b > 0) {
            System.out.println(1);
        } else if (a == b) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
    }
}
