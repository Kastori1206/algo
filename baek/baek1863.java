package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 스카이라인 쉬운거
 * https://www.acmicpc.net/problem/1863
 */
public class baek1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }
            stack.push(y);
        }

        while (!stack.isEmpty()) {
            if (stack.peek() > 0) {
                answer++;
            }
            stack.pop();
        }
        System.out.println(answer);
    }
}
