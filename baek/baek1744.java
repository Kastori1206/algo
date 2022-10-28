package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 수 묶기
 * https://www.acmicpc.net/problem/1744
 */
public class baek1744 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l =0;
        int r = N-1;
        for (; l < r; l += 2) {
            if (arr[l] < 1 && arr[l + 1] < 1) {
                answer += arr[l] * arr[l + 1];
            } else {
                break;
            }
        }

        for (; r > 0; r -= 2) {
            if (arr[r] > 1 && arr[r - 1] > 1) {
                answer += arr[r] * arr[r - 1];
            } else {
                break;
            }
        }

        for (; r >= l; r--) {
            answer += arr[r];
        }

        System.out.println(answer);
    }
}
