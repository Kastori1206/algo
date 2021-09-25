package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 전깃줄
 * https://www.acmicpc.net/problem/2565
 */
public class baek2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int len = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && map[i][1] > map[j][1]) {
                    dp[i] = dp[j] + 1;
                }
            }
            len = Math.max(len, dp[i]);
        }

        System.out.println(N - len);
    }
}
