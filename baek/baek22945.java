package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 팀 빌딩
 * https://www.acmicpc.net/problem/22945
 */
public class baek22945 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = N - 1;

        int answer = 0;
        while (l <= r) {
            int min = Math.min(arr[l], arr[r]);
            answer = Math.max((r - l - 1) * min, answer);
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(answer);
    }
}
