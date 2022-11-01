package groom.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 체크카드
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if (cmd.equals("deposit")) {
                N += k;
            } else if (cmd.equals("pay")) {
                if (N >= k) {
                    N -= k;
                }
            } else {
                if (q.isEmpty() && k <= N) {
                    N -= k;
                } else {
                    q.offer(k);
                }
            }
            while (!q.isEmpty()) {
                if (N < q.peek()) {
                    break;
                }
                N -= q.poll();
            }
        }

        System.out.println(N);
    }
}
