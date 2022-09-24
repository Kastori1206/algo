package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 등차수열 변환
 * https://www.acmicpc.net/problem/17088
 */
public class baek17088 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int answer = -1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int cnt = 0;
                if (i != 0) {
                    cnt++;
                }
                if (j != 0) {
                    cnt++;
                }
                int a1 = arr[0] + i;
                int d = arr[1] + j - a1;
                boolean flag = true;
                int start = a1 + d;
                for (int k = 2; k < N; k++) {
                    start += d;
                    if (arr[k] == start) {
                        continue;
                    } else if (arr[k] + 1 == start || arr[k] - 1 == start) {
                        cnt++;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (answer == -1 || answer > cnt) {
                        answer = cnt;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
