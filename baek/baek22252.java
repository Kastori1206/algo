package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 정보 상인 호석
 * https://www.acmicpc.net/problem/22252
 */
public class baek22252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> hm = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> q;
            switch (query) {
                case 1:
                    if (hm.containsKey(name)) {
                        q = hm.get(name);
                        for (int j = 0; j < k; j++) {
                            q.offer(Integer.parseInt(st.nextToken()));
                        }
                    } else {
                        q = new PriorityQueue<>(Collections.reverseOrder());
                        for (int j = 0; j < k; j++) {
                            q.offer(Integer.parseInt(st.nextToken()));
                        }
                    }
                    hm.put(name, q);
                    break;
                case 2:
                    if (hm.containsKey(name)) {
                        q = hm.get(name);
                        while (!q.isEmpty()) {
                            if (k <= 0) {
                                break;
                            }
                            answer += q.poll();
                            k--;
                        }
                        hm.put(name, q);
                    }
                    break;
            }
        }
        System.out.println(answer);
    }
}
