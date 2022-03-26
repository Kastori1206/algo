package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 좋은 단어
 * https://www.acmicpc.net/problem/3986
 */
public class baek3986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < str.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(str[j]);
                } else {
                    if (stack.peek() == str[j]) {
                        stack.pop();
                    } else {
                        stack.push(str[j]);
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
