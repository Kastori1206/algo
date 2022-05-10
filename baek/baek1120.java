package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문자열
 * https://www.acmicpc.net/problem/1120
 */
public class baek1120 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= b.length() - a.length(); i++) {
            int cnt =0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    cnt++;
                }
            }

            answer = Math.min(cnt, answer);
        }

        System.out.println(answer);
    }
}
