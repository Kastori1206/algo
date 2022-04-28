package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 */

public class baek2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer = 0;
        int temp = 1;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                temp *= 2;
                stack.push(ch);
            } else if (ch == '[') {
                temp *= 3;
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '(') {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 2;
                } else if (ch == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if (str.charAt(i - 1) == '[') {
                        answer += temp;
                    }
                    stack.pop();
                    temp /= 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(!stack.isEmpty() || !flag ? 0 : answer);
    }
}
