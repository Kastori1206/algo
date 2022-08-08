package swea.d5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10507. 영어 공부
 */
public class swea10507 {
    static int N, P, answer;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());

            visited = new boolean[1000000 + 1];
            answer = P + 1;

            int end = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int day = Integer.parseInt(st.nextToken());
                end = Math.max(end, day);
                visited[day] = true;
            }

            int l = 1;
            int r = 1;
            int res = 0;
            while (r < end + 1) {
                if (visited[r]) {
                    res++;
                    r++;
                    answer = Math.max(answer, res);
                } else {
                    if (P == 0) {
                        answer = Math.max(answer, res);
                        if (!visited[l]) {
                            P++;
                        }
                        l++;
                        res--;
                    } else {
                        P--;
                        res++;
                        r++;
                    }
                }
            }
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
}

