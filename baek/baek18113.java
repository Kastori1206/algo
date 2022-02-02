package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 그르다 김가놈
 * https://www.acmicpc.net/problem/18113
 */
public class baek18113 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > (2 * K)) {
                list.add(value - (2 * K));
            }
            if (2 * K > value && value > K) {
                list.add(value - K);
            }
        }

        int l = 1;
        int r = 1000000000;
        int answer = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int res = 0;
            for (int value : list) {
                res += (value / mid);
            }

            if (res >= M) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
