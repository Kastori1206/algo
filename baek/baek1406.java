package baek;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 에디터
 * https://www.acmicpc.net/problem/1406
 */
public class baek1406 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();

        char[] str = br.readLine().toCharArray();
        int N = str.length;

        for (int i = 0; i < N; i++) {
            l.push(str[i]);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("L")) {
                if (!l.isEmpty()) {
                    r.push(l.pop());
                }
            } else if (cmd.equals("D")) {
                if (!r.isEmpty()) {
                    l.push(r.pop());
                }
            } else if (cmd.equals("B")) {
                if (!l.isEmpty()) {
                    l.pop();
                }
            } else {
                char ch = st.nextToken().charAt(0);
                l.push(ch);
            }
        }

        while (!l.isEmpty()) {
            r.push(l.pop());
        }
        while (!r.isEmpty()) {
            sb.append(r.pop());
        }
        System.out.println(sb);
    }
}
