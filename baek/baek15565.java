package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 귀여운 라이언
 * https://www.acmicpc.net/problem/15565
 */
public class baek15565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) {
                list.add(i);
            }
        }

        if (list.size() < K) {
            System.out.println(-1);
            return;
        }

        int answer = Integer.MAX_VALUE;

        for (int l = 0; l < list.size(); l++) {
            int r = l;
            int cnt = 0;
            while (r < list.size() && cnt < K) {
                cnt++;
                r++;
            }

            if (cnt == K) {
                int ll = list.get(l);
                int rr = list.get(r - 1);
                answer = Math.min(answer, rr - ll + 1);
            }
        }

        System.out.println(answer);
    }
}
