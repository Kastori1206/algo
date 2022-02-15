package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 뉴턴의 사과
 * https://www.acmicpc.net/problem/4933
 */
public class baek4933 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            //nill = 0 'A' = 1 ~ 'Z' = 26
            int[] tree1 = new int[27];
            int[] tree2 = new int[27];

            st = new StringTokenizer(br.readLine());
            int root1 = makeTree(tree1, getStr(st));

            st = new StringTokenizer(br.readLine());
            int root2 = makeTree(tree2, getStr(st));

            boolean answer = root1 == root2;
            for (int i = 1; i < 27; i++) {
                if (!(answer &= (tree1[i] == tree2[i]))) {
                    break;
                }
            }
            System.out.println(answer ? "true" : "false");
        }

    }

    static List<Integer> getStr(StringTokenizer st) {
        List<Integer> res = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals("end")) {
                break;
            }
            if (temp.equals("nil")) {
                res.add(0);
            } else {
                res.add(temp.charAt(0) - 64);
            }
        }
        return res;
    }

    static int makeTree(int[] tree, List<Integer> str) {
        Stack<Integer> stack = new Stack<>();

        for (int cur : str) {
            if (cur == 0) {
                stack.push(0);
            } else {
                if (stack.size() >= 2) {
                    int right = stack.pop();
                    int left = stack.pop();

                    tree[right] = cur;
                    tree[left] = cur;
                }
                stack.push(cur);
            }
        }
        if (stack.size() == 0) {
            return 0;
        } else {
            return stack.peek();
        }
    }
}

