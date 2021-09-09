package programmers;

import java.util.Stack;

/**
 * 표 편집
 * https://programmers.co.kr/learn/courses/30/lessons/81303
 */
public class 표편집 {
    public static void main(String[] args) {
        int n = 8, k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n, k, cmd));
    }

    static class Node {
        boolean removed;
        Node pre, next;

    }

    public static String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Node[] arr = new Node[1000000];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node();
        }

        for (int i = 1; i < n; i++) {
            arr[i - 1].next = arr[i];
            arr[i].pre = arr[i - 1];
        }

        Node cur = arr[k];
        Stack<Node> history = new Stack<>();

        for (String c : cmd) {
            int x;
            Node top;
            Node bottom;
            switch (c.charAt(0)) {
                case 'U':
                    x = Integer.parseInt(c.substring(2));
                    for (int i = 0; i < x; i++) {
                        cur = cur.pre;
                    }
                    break;
                case 'D':
                    x = Integer.parseInt(c.substring(2));
                    for (int i = 0; i < x; i++) {
                        cur = cur.next;
                    }
                    break;
                case 'C':
                    history.push(cur);
                    cur.removed = true;
                    top = cur.pre;
                    bottom = cur.next;
                    if (top != null) {
                        top.next = bottom;
                    }

                    if (bottom != null) {
                        bottom.pre = top;
                        cur = bottom;
                    } else {
                        cur = top;
                    }
                    break;
                case 'Z':
                    Node z = history.pop();
                    z.removed = false;
                    top = z.pre;
                    bottom = z.next;
                    if (top != null) {
                        top.next = z;
                    }
                    if (bottom != null) {
                        bottom.pre = z;
                    }
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            answer.append(!arr[i].removed ? "O" : "X");
        }
        return answer.toString();
    }
}
