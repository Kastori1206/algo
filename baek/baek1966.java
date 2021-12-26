package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 프린터 큐
 * https://www.acmicpc.net/problem/1966
 */
public class baek1966 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                boolean flag = true;

                for (int i = 0; i < q.size(); i++) {
                    if (temp[1] < q.get(i)[1]) {
                        q.offer(temp);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    continue;
                }
                cnt++;
                if (temp[0] == M) {
                    break;
                }
            }
            answer.append(cnt).append("\n");
        }

        System.out.println(answer);
    }
}
