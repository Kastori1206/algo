package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 수열
 * https://www.acmicpc.net/problem/1874
 */
public class baek1874 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (idx < n) {
                for (int j = idx + 1; j <= n; j++) {
                    stack.push(j);
                    sb.append('+').append("\n");
                }
                idx = n;
            } else if (stack.peek() != n) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append("\n");
        }
        System.out.println(sb);
    }
}

