package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 사촌
 * https://www.acmicpc.net/problem/9489
 */
public class baek9489 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) {
                break;
            }

            int target = 0;
            int[] arr = new int[n + 1];
            int[] p = new int[n + 1];
            int idx = -1;
            p[0] = -1;
            arr[0] = -1;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == k) {
                    target = i;
                }
                if (arr[i] != arr[i - 1] + 1) {
                    idx++;
                }
                p[i] = idx;
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (p[i] != p[target] && p[p[i]] == p[p[target]]) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
