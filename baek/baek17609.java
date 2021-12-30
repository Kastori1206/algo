package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 회문
 * https://www.acmicpc.net/problem/17609
 */
public class baek17609 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int l = 0, r = str.length() - 1;
            int cnt = 0;
            boolean flag = false;

            while (l <= r) {
                if (str.charAt(l) != str.charAt(r)) {
                    if (check(str, l + 1, r)) {
                        l++;
                        cnt++;
                    } else if (check(str, l, r - 1)) {
                        r--;
                        cnt++;
                    }
                    if (cnt == 0) {
                        answer.append(2 + "\n");
                        flag = true;
                        break;
                    }
                } else {
                    l++;
                    r--;
                }
                if (cnt >= 2) {
                    answer.append(2 + "\n");
                    break;
                }
            }
            if (flag) {
                continue;
            }
            if (cnt == 1) {
                answer.append(1 + "\n");
            } else if (cnt == 0) {
                answer.append(0 + "\n");
            }
        }
        System.out.println(answer);
    }

    static boolean check(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
