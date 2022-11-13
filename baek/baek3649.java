package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 로봇 프로젝트
 * https://www.acmicpc.net/problem/3649
 */

public class baek3649 {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while ((input = br.readLine()) != null) {

            int x = Integer.parseInt(input) * 10000000;

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);


            binarySearch(arr, x);

        }
        System.out.println(answer);
    }

    static void binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == x) {
                answer.append("yes ").append(arr[l]).append(" ").append(arr[r]).append("\n");
                return;
            }
            if (arr[l] + arr[r] > x) {
                r--;
            } else {
                l++;
            }
        }

        answer.append("danger").append("\n");
    }
}
