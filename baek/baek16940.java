package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS 스페셜 저지
 * https://www.acmicpc.net/problem/16940
 */
public class baek16940 {
    static List<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];

        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }
        int[] nums = new int[N + 1];
        int[] p = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = true;

        int idx = 2;

        for (int i = 1; i <= N; i++) {
            if (q.isEmpty()) {
                System.out.println(0);
                return;
            }
            int cur = q.poll();
            if (cur != nums[i]) {
                System.out.println(0);
                return;
            }

            int cnt = 0;
            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                p[next] = cur;
                cnt++;
            }
            for (int j = 0; j < cnt; j++) {
                if (j + idx > N || p[nums[j + idx]] != cur) {
                    System.out.println(0);
                    return;
                }
                q.offer(nums[j + idx]);
                visited[nums[j + idx]] = true;
            }
            idx += cnt;
        }
        System.out.println(1);
    }
}
