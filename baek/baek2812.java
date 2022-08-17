package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 크게 만들기
 * https://www.acmicpc.net/problem/2812
 */
public class baek2812 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Character> dq = new ArrayDeque<>();


        String num = br.readLine();
        for (int i = 0; i < N; i++) {
            char ch = num.charAt(i);
            while (K > 0 && !dq.isEmpty() && dq.getLast() < ch) {
                dq.removeLast();
                K--;
            }
            dq.addLast(ch);
        }

        StringBuilder answer = new StringBuilder();
        while (dq.size() > K) {
            answer.append(dq.removeFirst());
        }
        System.out.println(answer);
    }
}
