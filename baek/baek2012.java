package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 등수 매기기
 * https://www.acmicpc.net/problem/2012
 */
public class baek2012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += Math.abs(arr[i] - (i + 1));
        }
        System.out.println(answer);
    }
}
