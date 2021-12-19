package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최소 회의실 개수
 * https://www.acmicpc.net/problem/19598
 */
public class baek19598 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        //회의시간이 가장 빠르게 끝나는 순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new int[]{start, end});
        }

        //회의시작 시간이 빠른 순으로 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        //첫번째 회의가 끝나는 시간 pq에 넣고, 회의실 1개 부터 계산
        pq.offer(list.get(0)[1]);
        int answer = 1;

        for (int i = 1; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= list.get(i)[0]) {
                pq.poll();
            }
            pq.offer(list.get(i)[1]);
            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}
