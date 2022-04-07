package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 수 고르기
 * https://www.acmicpc.net/problem/2230
 */
public class baek2230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int r = 0;
        for (int l = 0; l < N; l++) {
            while (r + 1 < N && arr[r] - arr[l] < M) {
                r++;
            }
            if (arr[r] - arr[l] >= M) {
                answer = Math.min(answer, arr[r] - arr[l]);
            }
        }

        System.out.println(answer);
    }
}
