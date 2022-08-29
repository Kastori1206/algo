package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * DFS 스페셜 저지
 * https://www.acmicpc.net/problem/16964
 */
public class baek16964 {
    static int[] target;
    static boolean[] visited;
    static int idx;
    static List<Integer>[] adj;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        idx = 0;
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
        target = new int[N];
        int[] nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
            nums[target[i]] = i;
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i], (o1, o2) -> Integer.compare(nums[o1], nums[o2]));
        }

        visited[1] = true;
        System.out.println(dfs(1) ? 1 : 0);
    }

    static boolean dfs(int cur) {
        if (target[idx++] != cur) {
            return false;
        }
        for (int next : adj[cur]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            return dfs(next);
        }
        return true;
    }
}
