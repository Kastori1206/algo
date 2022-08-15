package swea.d6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1257. [S/W 문제해결 응용] 6일차 - K번째 문자열
 */
public class swea1257 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();

            TreeSet<String> ts = new TreeSet<>();
            int N = str.length();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - i; j++) {
                    ts.add(str.substring(i, i + j + 1));
                }
            }

            String answer = "none";
            if (ts.size() >= K) {
                Iterator iter = ts.iterator();
                while (K > 1) {
                    K--;
                    iter.next();
                }
                answer = (String) iter.next();
            }

            sb.append(String.format("#%d %s\n", t, answer));

        }
        System.out.print(sb);
    }
}
