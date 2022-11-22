package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 계란으로 계란치기
 * https://www.acmicpc.net/problem/16987
 */
public class baek16987 {
    static int N, answer;
    static int[] S, W;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N];
        W = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int cur) {
        if (cur == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (S[i] <= 0) {
                    cnt++;
                }
            }
            answer = Math.max(cnt, answer);
            return;
        }
        if (S[cur] <= 0) {
            dfs(cur + 1);
        } else {
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if (i == cur || S[i] <= 0) {
                    continue;
                }

                flag = true;
                S[i] -= W[cur];
                S[cur] -= W[i];
                dfs(cur + 1);
                S[i] += W[cur];
                S[cur] += W[i];
            }
            if (!flag) {
                dfs(cur + 1);
            }
        }
    }
}
