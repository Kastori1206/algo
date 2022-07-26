package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1232. [S/W 문제해결 기본] 9일차 - 사칙연산
 */
public class swea1232 {
    static int[][] tree;
    static String[] ops;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();


        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());

            tree = new int[N + 1][2];
            ops = new String[N + 1];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                String input = st.nextToken();
                ops[v] = input;
                if (input.equals("-") || input.equals("+") || input.equals("/") || input.equals("*")) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    tree[v][0] = a;
                    tree[v][1] = b;
                }
            }

            double answer = dfs(1);
            sb.append(String.format("#%d %d\n", t, (int)answer));
        }
        System.out.println(sb);
    }
    static double dfs(int cur) {
        if (tree[cur][0] != 0) {
            double a = dfs(tree[cur][0]);
            double b = dfs(tree[cur][1]);

            return calc(a, b, ops[cur]);
        }
        return Double.parseDouble(ops[cur]);
    }

    static double calc(double a, double b, String op){
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return -1;
    }
}
