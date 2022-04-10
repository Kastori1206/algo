package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 고냥이
 * https://www.acmicpc.net/problem/16472
 */
public class baek16472 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        if (arr.length <= N) {
            System.out.println(arr.length);
            return;
        }
        int[] alpha = new int[26];
        int answer = 0;
        int l = 0, r = 0, diff = 0;
        alpha[arr[0] - 'a']++;
        diff++;

        while (true) {
            r++;
            if (r == arr.length) {
                break;
            }
            int idx = arr[r] - 'a';
            alpha[idx]++;

            if (alpha[idx] == 1) {
                diff++;
            }
            while (diff > N) {
                idx = arr[l] - 'a';
                alpha[idx]--;
                if (alpha[idx] == 0) {
                    diff--;
                }
                l++;
            }
            answer = Math.max(answer, r - l + 1);
        }

        System.out.println(answer);
    }

}
