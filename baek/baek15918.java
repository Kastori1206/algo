package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 랭퍼든 수열쟁이야!!
 * https://www.acmicpc.net/problem/15918
 */
public class baek15918 {
    static int N, x, y;
    static int[] arr;
    static boolean[] visited;
    static long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[25];
        visited = new boolean[25];

        visited[y - x - 1] = true;
        arr[x] = y - x - 1;
        arr[y] = y - x - 1;

        dfs(1);
        System.out.println(answer);

    }
    static void dfs(int idx) {
        if (idx == 2 * N) {
            answer++;
            return;
        }
        if (arr[idx] == 0) {
            for (int i = 1; i <= N; i++) {
                if (visited[i]) {
                    continue;
                }
                if (idx + i + 1 <= 2 * N && arr[idx + i + 1] == 0) {
                    arr[idx] = arr[idx + i + 1] = i;
                    visited[i] = true;
                    dfs(idx + 1);
                    arr[idx] = arr[idx + i + 1] = 0;
                    visited[i] = false;
                }
            }
        } else {
            dfs(idx + 1);
        }
    }
}
