package groom.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경로의 개수
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long answer = 1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answer *= Integer.parseInt(st.nextToken());
        }

        System.out.println(answer);
    }
}
