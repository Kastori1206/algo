package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 생성
 * https://www.acmicpc.net/problem/6137
 */
public class baek6137 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        List<Character> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        int l = 0, r = N - 1;

        while (l <= r) {
            if (arr[l] < arr[r]) {
                answer.add(arr[l++]);
            } else if (arr[l] == arr[r]) {
                int ll = l, rr = r;
                boolean flag = true;

                while (arr[ll] == arr[rr]) {
                    if (rr > 0) {
                        rr--;
                    }
                    if (ll < N - 1) {
                        ll++;
                    }
                    if (arr[ll] < arr[rr]) {
                        flag = true;
                    } else if (arr[ll] > arr[rr]) {
                        flag = false;
                    }
                }
                if (flag) {
                    answer.add(arr[l++]);
                } else {
                    answer.add(arr[r--]);
                }

            } else {
                answer.add(arr[r--]);
            }
        }
        for (int i = 0; i < N; i++) {
            if (i != 0 && i % 80 == 0) {
                System.out.println();
            }
            System.out.print(answer.get(i));
        }
    }
}

