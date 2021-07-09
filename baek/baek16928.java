package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 뱀과 사다리 게임
 * https://www.acmicpc.net/problem/16928
 */
public class baek16928 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[] memo = new int[100 + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) {
                    continue;
                }
                if (map.containsKey(next)) {
                    next = map.get(next);
                }
                if (memo[next] == 0) {
                    memo[next] = memo[cur] + 1;
                    q.offer(next);
                } else if (memo[next] > memo[cur] + 1) {
                    memo[next] = memo[cur] + 1;
                    q.offer(next);
                }
            }
        }
        bw.write(String.valueOf(memo[100]));
        br.close();
        bw.close();
    }
}
