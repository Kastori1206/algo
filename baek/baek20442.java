package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ㅋㅋ루ㅋㅋ
 * https://www.acmicpc.net/problem/20442
 */
public class baek20442 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> lk = new ArrayList<>();
        List<Integer> rk = new ArrayList<>();


        String str = br.readLine();
        int N = str.length();
        int lcnt = 0;
        int rcnt = 0;

        for (int i = 0; i < N; i++) {
            if (str.charAt(i) == 'K') {
                lcnt++;
            } else {
                lk.add(lcnt);
            }

            if (str.charAt(N - 1 - i) == 'K') {
                rcnt++;
            } else {
                rk.add(rcnt);
            }
        }

        rk.sort(Comparator.reverseOrder());

        int l = 0;
        int r = rk.size() - 1;

        int max = 0;

        while (l <= r) {
            max = Math.max(max, (r - l + 1) + (2 * Math.min(lk.get(l), rk.get(r))));

            if (lk.get(l) < rk.get(r)) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println(max);
    }
}
