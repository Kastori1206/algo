package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 같은 수로 만들기
 * https://www.acmicpc.net/problem/2374
 */
public class baek2374 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());
            max = Math.max(A, max);

            if (stack.isEmpty()) {
                stack.push(A);
            } else {
                int temp = stack.pop();
                if (temp < A) {
                    answer += A - temp;
                }
                stack.push(A);
            }
        }

        while (!stack.isEmpty()) {
            answer += max - stack.pop();
        }

        System.out.println(answer);
    }
}
