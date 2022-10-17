package groom.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 철자 분리 집합
 */
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int answer = 1;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
