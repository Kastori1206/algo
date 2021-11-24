package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가장 가까운 공통 조상
 * https://www.acmicpc.net/problem/3584
 */
public class baek3584 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] parents = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                parents[v2] = v1;
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            Set<Integer> set = new HashSet<>();
            while (true) {
                set.add(v1);
                if (parents[v1] == 0) {
                    break;
                }

                v1 = parents[v1];
            }

            while (true) {
                if (set.remove(v2)) {
                    break;
                }
                v2 = parents[v2];
            }
            answer.append(v2).append("\n");
        }
        System.out.println(answer.toString());

    }
}
