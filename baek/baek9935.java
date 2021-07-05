package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 문자열 폭발
 * https://www.acmicpc.net/problem/9935
 */
public class baek9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String pattern = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            stack.push(c);
            if (stack.size() >= pattern.length()) {
                boolean flag = true;
                for (int j = 0; j < pattern.length(); j++) {
                    char temp = stack.get(stack.size() - pattern.length() + j);
                    if (temp != pattern.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < pattern.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            answer.append("FRULA");
        } else {
            for (Character ch : stack) {
                answer.append(ch);
            }
        }

        System.out.println(answer.toString());

    }
}
