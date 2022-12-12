package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 주식
 * https://www.acmicpc.net/problem/11501
 */
public class baek11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            long answer = 0;
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = Integer.MIN_VALUE;
            for (int i = N-1; i >=0 ; i--) {
                if (max < arr[i]) {
                    max = arr[i];
                } else {
                    answer += (max - arr[i]);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
