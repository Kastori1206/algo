package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * swea2948. 문자열 교집합
 */
public class swea2948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Set<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(st.nextToken());
            }

            int answer = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                answer = set.contains(st.nextToken()) ? answer + 1 : answer;
            }
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
}
