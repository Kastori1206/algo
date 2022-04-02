package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 나무 위의 구슬
 * https://www.acmicpc.net/problem/14570
 */
public class baek14570 {
    static int N;
    static List<int[]>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[i].add(new int[]{a, b});
        }

        long K = Long.parseLong(br.readLine());

        dfs(1, K);
    }

    static void dfs(int cur, long k) {
        for (int[] next : adj[cur]) {
            int left = next[0];
            int right = next[1];

            if (left == -1 && right == -1) {
                System.out.println(cur);
                return;
            } else if (left != -1 && right != -1) {
                if (k % 2 == 1) {
                    dfs(left, k / 2 + 1);
                } else {
                    dfs(right, k / 2);
                }
            } else if (left == -1) {
                dfs(right, k);
            } else {
                dfs(left, k);
            }
        }
    }

}

