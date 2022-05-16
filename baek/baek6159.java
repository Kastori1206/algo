package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 코스튬 파티
 * https://www.acmicpc.net/problem/6159
 */
public class baek6159 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N - 1; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < N; j++) {
                if (sum + arr[j] <= S) {
                    answer++;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
