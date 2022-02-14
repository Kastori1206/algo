package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 최소 공배수
 * https://www.acmicpc.net/problem/21919
 */
public class baek21919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long answer = 1;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        boolean[] prime = new boolean[max + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * 2; j <= max; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            if (prime[arr[i]]) {
                continue;
            }
            answer *= arr[i];
            //같은수 중복제거
            prime[arr[i]] = true;
        }


        System.out.println(answer == 1 ? -1 : answer);

    }
}
