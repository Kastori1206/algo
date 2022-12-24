package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 좋다
 * https://www.acmicpc.net/problem/1253
 */
public class baek1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int l = 0;
            int r = N - 1;


            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == arr[i]) {
                    if (i == l) {
                        l++;
                    } else if (r == i) {
                        r--;
                    } else {
                        answer++;
                        break;
                    }
                }
                if (sum > arr[i]) {
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                }
            }
        }

        System.out.println(answer);
    }
}
