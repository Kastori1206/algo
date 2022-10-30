package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * AB
 * https://www.acmicpc.net/problem/12970
 */
public class baek12970 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int A = N / 2;
        int B = N - A;

        if (K > A * B) {
            answer.append("-1");
        } else if (K == A * B) {
            while (A-- > 0) {
                answer.append("A");
            }
            while (B-- > 0) {
                answer.append("B");
            }
        } else {
            int a = K / B;
            int b = K % B;

            int aa = A - a - 1;
            int bb = B - b;

            while (a-- > 0) {
                answer.append("A");
            }
            while (bb-- > 0) {
                answer.append("B");
            }
            answer.append("A");
            while (b-- > 0) {
                answer.append("B");
            }
            while (aa-- > 0) {
                answer.append("A");
            }
        }
        System.out.println(answer);
    }
}
