package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * IOIOI
 * https://www.acmicpc.net/problem/5525
 */
public class baek5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int answer = 0;
        int[] d = new int[M];

        for (int i = 1; i < M - 1; i++) {
            if (str.charAt(i) != 'O') {
                continue;
            }
            if (str.charAt(i - 1) == 'I' && str.charAt(i + 1) == 'I') {
                d[i - 1] = d[i] = d[i + 1] = d[i - 1] + 1;
                if (d[i] >= N) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
