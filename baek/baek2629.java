package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 양팔저울
 * https://www.acmicpc.net/problem/2629
 */
public class baek2629 {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][30 * 500 + 40000 + 1];
        dfs(0, 0);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int w = Integer.parseInt(st.nextToken());
            if (dp[N][w]) {
                answer.append("Y ");
            } else {
                answer.append("N ");
            }
        }
        System.out.println(answer.toString());

    }

    static void dfs(int idx, int w) {

        if (dp[idx][w]) {
            return;
        }
        dp[idx][w] = true;
        if (idx == N) {
            return;
        }
        System.out.println(idx + " " + w);
        //추 무게 합
        dfs(idx + 1, w + arr[idx]);
        //해당 추를 사용 안하는 경우
        dfs(idx + 1, w);
        //구슬이 있는 쪽에 추는 놓는 경우
        dfs(idx + 1, Math.abs(w - arr[idx]));
    }
}
