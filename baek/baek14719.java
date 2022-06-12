package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빗물
 * https://www.acmicpc.net/problem/14719
 */
public class baek14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 1; i < W; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                l = Math.max(arr[j], l);
            }
            for (int j = i + 1; j < W; j++) {
                r = Math.max(arr[j], r);
            }

            if (arr[i] < l && arr[i] < r) {
                answer += Math.min(l, r) - arr[i];
            }
        }
        System.out.println(answer);
    }
}
