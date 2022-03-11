package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비트 우정지수
 * https://www.acmicpc.net/problem/12782
 */
public class baek12782 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            String num1 = st.nextToken();
            String num2 = st.nextToken();

            int one = 0;
            int zero = 0;

            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) != num2.charAt(i)) {
                    if (num1.charAt(i) == '1') {
                        one++;
                    } else {
                        zero++;
                    }
                }
            }
            int answer = (one + zero) - Math.min(one, zero);

            sb.append(answer).append("\n");
        }
        System.out.println(sb);


    }
}
