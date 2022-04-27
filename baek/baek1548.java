package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 부분 삼각 수열
 * https://www.acmicpc.net/problem/1548
 */
public class baek1548 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 1;

        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (i + 1 == j) {
                    break;
                }
                if (arr[i] + arr[i + 1] > arr[j]) {
                    answer = Math.max(answer, j - i + 1);
                    break;
                }
            }
        }

        if (answer == 1 && N >= 2) {
            answer = 2;
        }
        System.out.println(answer);
    }

}
