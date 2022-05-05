package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문서 검색
 * https://www.acmicpc.net/problem/1543
 */
public class baek1543 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();

        if (str.length < p.length) {
            System.out.println(0);
        } else {
            int answer = 0;
            int idx = 0;

            for (int i = idx; i < str.length - p.length + 1; i++) {
                boolean flag = true;
                for (int j = 0; j < p.length; j++) {
                    if (str[i + j] != p[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                    idx += p.length;
                    i = idx - 1;
                } else {
                    idx++;
                }
            }

            System.out.println(answer);
        }
    }
}
