package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전 초밥
 * https://www.acmicpc.net/problem/15961
 */
public class baek15961 {
    static int N, D, K , C;
    static int[] arr, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new int[D + 1];
        int cnt = 0;
        int answer = 0;

        for (int i = 0; i < K; i++) {
            if (visited[arr[i]] == 0) {
                cnt++;
            }
            visited[arr[i]]++;
        }
        answer = cnt;
        for (int i = 1; i < N; i++) {
            if (answer <= cnt) {
                if (visited[C] == 0) {
                    answer = cnt + 1;
                } else {
                    answer = cnt;
                }
            }
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                cnt--;
            }
            if (visited[arr[(i + K - 1) % N]] == 0) {
                cnt++;
            }
            visited[arr[(i + K - 1) % N]]++;
        }

        System.out.println(answer);
    }

}
