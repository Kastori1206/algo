package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 당근 훔쳐 먹기
 * https://www.acmicpc.net/problem/18234
 */
public class baek18234 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        long answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long w = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());

            pq.offer(new long[]{p, w});
        }

        int i = 0;
        while (!pq.isEmpty()) {
            long[] temp = pq.poll();
            answer += temp[1] + (temp[0] * (T - N + i++));
        }
        System.out.println(answer);
    }
}
