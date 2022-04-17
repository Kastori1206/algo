package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 귀여운 라이언
 * https://www.acmicpc.net/problem/15565
 */
public class baek15565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        int answer = -1;
        int sum = 0;
        for (int l = 1; l <= N; l++) {
            while (r < N && sum < K) {
                r++;
                if (arr[r] == 1) {
                    sum++;
                }
            }

            if (sum == K) {
                if (answer == -1) {
                    answer = r - l + 1;
                }
                answer = Math.min(answer, r - l + 1);
            }

            if (arr[l] == 1) {
                sum--;
            }
        }
        System.out.println(answer);
    }
}
