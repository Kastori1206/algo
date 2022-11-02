package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 새로운 하노이 탑
 * https://www.acmicpc.net/problem/12906
 */
public class baek12906 {
    static class Node {
        String A;
        String B;
        String C;

        int cnt;

        public Node(String a, String b, String c, int cnt) {
            A = a;
            B = b;
            C = c;
            this.cnt = cnt;
        }

        public String getKey() {
            return A + " " + B + " " + C;
        }

        @Override
        public String toString() {
            return "Node{" + "A='" + A + '\'' + ", B='" + B + '\'' + ", C='" + C + '\'' + ", cnt=" + cnt + '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Set<String> set = new HashSet<>();

        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            if (c == 0) {
                input[i] = "";
            } else {
                input[i] = st.nextToken();
            }
        }

        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
        Node start = new Node(input[0], input[1], input[2], 0);
        pq.offer(start);
        set.add(start.getKey());

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            String A = cur.A;
            String B = cur.B;
            String C = cur.C;
            int cnt = cur.cnt;

            if (check(cur)) {
                answer = cur.cnt;
                break;
            }

            if (A.length() >= 1) {
                char last = A.charAt(A.length() - 1);

                Node next = new Node(A.substring(0, A.length() - 1), B + last, C, cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
                next = new Node(A.substring(0, A.length() - 1), B, C + last, cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
            }

            if (B.length() >= 1) {
                char last = B.charAt(B.length() - 1);

                Node next = new Node(A + last, B.substring(0, B.length() - 1), C, cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
                next = new Node(A, B.substring(0, B.length() - 1), C + last, cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
            }


            if (C.length() >= 1) {
                char last = C.charAt(C.length() - 1);

                Node next = new Node(A + last, B, C.substring(0, C.length() - 1), cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
                next = new Node(A, B + last, C.substring(0, C.length() - 1), cnt + 1);
                if (!set.contains(next.getKey())) {
                    set.add(next.getKey());
                    pq.offer(next);
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean check(Node cur) {
        for (int i = 0; i < cur.A.length(); i++) {
            if (cur.A.charAt(i) != 'A') {
                return false;
            }
        }
        for (int i = 0; i < cur.B.length(); i++) {
            if (cur.B.charAt(i) != 'B') {
                return false;
            }
        }
        for (int i = 0; i < cur.C.length(); i++) {
            if (cur.C.charAt(i) != 'C') {
                return false;
            }
        }
        return true;
    }

}
