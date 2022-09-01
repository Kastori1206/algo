package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 나3곱2
 * https://www.acmicpc.net/problem/16936
 */
public class baek16936 {
    static boolean[] visited;
    static int N;
    static long[] arr;
    static List<Long> answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            answer = new ArrayList<>();
            dfs(i);
        }

    }

    static void dfs(int idx) {
        long cur = arr[idx];
        answer.add(cur);
        if (answer.size() == N) {
            for (Long num : answer) {
                System.out.print(num + " ");
            }
            System.exit(0);
        }
        visited[idx] = true;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }
            if (cur % 3 == 0 && cur / 3 == arr[i]) {
                dfs(i);
            }
            if (cur * 2 == arr[i]) {
                dfs(i);
            }
        }
    }
}
