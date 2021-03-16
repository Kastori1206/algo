package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 기차 여행
 * https://www.acmicpc.net/problem/10713
 */
public class baek10713 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] p = new int[N + 1];
        int[][] rails = new int[N + 1][3];
        int[] cnts = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            p[i] = Integer.parseInt(st.nextToken());
            if (i > 1) {
                int pre = p[i - 1];
                int next = p[i];

                if (pre > next) {
                    int temp = pre;
                    pre = next;
                    next = temp;
                }

                cnts[pre]++;
                cnts[next]--;
            }
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rails[i][0] = a;
            rails[i][1] = b;
            rails[i][2] = c;
        }


        long answer = 0, sum = 0;
        for (int i = 1; i < N; i++) {
            sum += cnts[i];
            answer += Math.min(sum * rails[i][0], sum * rails[i][1] + rails[i][2]);
        }

        System.out.println(answer);
    }
}
