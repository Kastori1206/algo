package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 택배
 * https://www.acmicpc.net/problem/1719
 */
public class baek1719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][N + 1];
        int[][] path = new int[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            Arrays.fill(dist[r], 987654321);
            dist[r][r] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = d;
            path[a][b] = b;
            path[b][a] = a;
        }
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int d = dist[i][k] + dist[k][j];
                    if (dist[i][j] > d) {
                        dist[i][j] = d;
                        if (i != k) {
                            path[i][j] = path[i][k];
                        }
                    }
                }
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                answer.append(path[r][c] == 0 ? "-" : path[r][c]).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}
