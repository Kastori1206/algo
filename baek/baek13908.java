package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 비밀번호
 * https://www.acmicpc.net/problem/13908
 */
public class baek13908 {
    static int N, M, answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[10];
        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int idx = Integer.parseInt(st.nextToken());
                visited[idx] = true;
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int idx, int cnt) {
        if (idx == N) {
            if (cnt == M) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                visited[i] = false;
                dfs(idx + 1, cnt + 1);
                visited[i] = true;
            } else {
                dfs(idx + 1, cnt);
            }
        }
    }
}
