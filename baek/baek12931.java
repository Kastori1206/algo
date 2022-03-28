package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 배 더하기
 * https://www.acmicpc.net/problem/12931
 */
public class baek12931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;

        while (flag) {
            flag = false;
            boolean check = false;

            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1 && arr[i] > 0) {
                    arr[i]--;
                    answer++;
                }
                if (arr[i] != 0) {
                    check = true;
                }
            }
            if (check) {
                for (int i = 0; i < N; i++) {
                    arr[i] /= 2;
                }
                answer++;
            }

            for (int i = 0; i < N; i++) {
                if (arr[i] != 0) {
                    flag = true;
                }
            }
        }

        System.out.println(answer);
    }
}
