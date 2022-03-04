package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가운데에서 만나기
 * https://www.acmicpc.net/problem/21940
 */
public class baek21940 {
    static final int INF = 987654321;
    static int[][] map;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int r = 0; r <= N; r++) {
            Arrays.fill(map[r], INF);
            map[r][r] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            map[a][b] = Math.min(map[a][b], t);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        K = Integer.parseInt(br.readLine());
        int[] C = new int[K];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(st.nextToken());
        }

        int[] max = new int[N + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < K; j++) {
                int dist = map[C[j]][i] + map[i][C[j]];
                max[i] = Math.max(max[i], dist);
            }
            min = Math.min(min, max[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (min >= max[i]) {
                answer.add(i);
            }
        }
        Collections.sort(answer);

        for (Integer v : answer) {
            System.out.print(v + " ");
        }
    }
}
