package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호
 * https://www.acmicpc.net/problem/9012
 */
public class baek9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] input = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (flag && stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
