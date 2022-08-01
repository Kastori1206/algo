package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 용액 합성하기
 * https://www.acmicpc.net/problem/14921
 */
public class baek14921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N - 1;
        int min = Integer.MAX_VALUE;
        int answer = -1;

        while (l < r) {
            int res = arr[r] + arr[l];
            if (Math.abs(res) < min) {
                min = Math.abs(res);
                answer = res;
            }
            if (res > 0) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(answer);
    }
}
