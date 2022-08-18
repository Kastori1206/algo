package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 숫자고르기
 * https://www.acmicpc.net/problem/2668
 */
public class baek2668 {
    static int[] adj;
    static List<Integer> answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        adj = new int[N + 1];
        answer = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (Integer num : answer) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int target) {
        int next = adj[start];
        if (!visited[next]) {
            visited[next] = true;
            dfs(next, target);
            visited[next] = false;
        }
        if (next == target) {
            answer.add(target);
        }
    }
}
