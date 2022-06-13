package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 게임 개발
 * https://www.acmicpc.net/problem/1516
 */
public class baek1516 {
    static List<Integer>[] adj;
    static int[] inDgree, times, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        inDgree = new int[N + 1];
        times = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }

                adj[n].add(i);
                inDgree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (inDgree[i] == 0) {
                q.offer(i);
                answer[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                inDgree[next]--;
                answer[next] = Math.max(answer[next], answer[cur] + times[next]);
                if (inDgree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}
