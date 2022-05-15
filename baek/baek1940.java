package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주몽
 * https://www.acmicpc.net/problem/1940
 */
public class baek1940 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            int end = i + 1;
            while (end < N) {
                sum = arr[i];
                sum += arr[end++];
                if (sum == M) {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
