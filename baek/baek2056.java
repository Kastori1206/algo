package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작업
 * https://www.acmicpc.net/problem/2056
 */
public class baek2056 {

    static int N;
    static List<Integer>[] adj;
    static int[] indgree, time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        time = new int[N + 1];
        indgree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(st.nextToken());
                adj[a].add(i);
                indgree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] t = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            t[i] = time[i];
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                indgree[next]--;

                t[next] = Math.max(t[next], t[cur] + time[next]);

                if (indgree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, t[i]);
        }

        System.out.println(answer);
    }
}
