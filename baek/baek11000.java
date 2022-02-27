package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 강의실 배정
 * https://www.acmicpc.net/problem/11000
 */
public class baek11000 {
    static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[i] = new Node(s, e);
        }

        Arrays.sort(arr, (o1, o2) -> o1.s == o2.s ? o1.e - o2.e : o1.s - o2.s);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].e);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].s) {
                pq.poll();
            }
            pq.offer(arr[i].e);
        }

        System.out.println(pq.size());
    }
}
