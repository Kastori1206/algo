package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 세 친구
 * https://www.acmicpc.net/problem/17089
 */
public class baek17089 {
    static boolean[][] map;
    static int[] cnt;
    static int N , M, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;

        map = new boolean[N + 1][N + 1];
        cnt = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
            map[b][a] = true;
            cnt[a]++;
            cnt[b]++;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!map[i][j]) {
                    continue;
                }
                for (int k = 1; k <= N; k++) {
                    if (!(map[i][k] && map[j][k])) {
                        continue;
                    }
                    int res = cnt[i] + cnt[j] + cnt[k] - 6;
                    answer = Math.min(res, answer);
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }
}
