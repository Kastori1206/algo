package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전 초밥
 * https://www.acmicpc.net/problem/2531
 */
public class baek2531 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] eat = new int[d + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) {
                cnt++;
            }

            eat[arr[i]]++;
        }
        int max = cnt;

        for (int i = 1; i < N; i++) {
            if (max <= cnt) {
                if (eat[c] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            int e = (i + k - 1) % N;

            if (eat[arr[e]] == 0) {
                cnt++;
            }
            eat[arr[e]]++;

            eat[arr[i - 1]]--;
            if (eat[arr[i - 1]] == 0) {
                cnt--;
            }
        }
        System.out.println(max);
    }
}
