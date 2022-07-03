package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 캠프 준비
 * https://www.acmicpc.net/problem/16938
 */
public class baek16938 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        for (int i = 0; i < (1<<N); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int cnt = 0;
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & 1 << j) != 0) {
                    sum += arr[j];
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                    cnt++;

                }

            }
            if (cnt > 1 && sum <= R && sum >= L && max - min >= X) {
                answer++;
            }

        }
        System.out.println(answer);
    }
}
