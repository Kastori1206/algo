package groom.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 동명이인
 */
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.contains(s)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
