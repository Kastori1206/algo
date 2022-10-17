package groom.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 합격자 찾기
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            double sum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            Arrays.sort(arr);
            double avg = sum / n;
            int answer = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (avg > arr[i]) {
                    break;
                }
                answer++;
            }
            sb.append(answer).append("/").append(n).append("\n");
        }
        System.out.print(sb);
    }
}
