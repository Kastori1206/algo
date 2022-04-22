package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 좋은 수
 * https://www.acmicpc.net/problem/5624
 */
public class baek5624 {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] check = new boolean[2 * MAX + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            //a + b + c = d  -> a + b = d - c
            for (int j = 0; j < i; j++) {
                int d = arr[i];
                int c = arr[j];
                if (d - c > MAX || d - c < -MAX) {
                    continue;
                }
                if (check[d - c + MAX]) {
                    answer++;
                    break;
                }
            }
            for (int j = 0; j <= i; j++) {
                int a = arr[i];
                int b = arr[j];
                if (a + b > MAX || a + b < -MAX) {
                    continue;
                }
                check[a + b + MAX] = true;
            }
        }
        System.out.println(answer);
    }

}
