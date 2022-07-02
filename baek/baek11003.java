package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최솟값 찾기
 * https://www.acmicpc.net/problem/11003
 */
public class baek11003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekFirst()[0] > num) {
                dq.pollLast();
            }
            dq.offer(new int[]{num, i});
            if (dq.peek()[1] < i - (L - 1)) {
                dq.poll();
            }
            sb.append(dq.peek()[0] + " ");
        }

        System.out.println(sb);


    }
}
