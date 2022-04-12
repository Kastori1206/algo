package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * List of Unique Numbers
 * https://www.acmicpc.net/problem/13144
 */
public class baek13144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[100000 + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int r = -1;

        for (int l = 0; l < N; l++) {
            while (r + 1 < N && !visited[arr[r + 1]]) {
                r++;
                visited[arr[r]] = true;
            }

            answer += r - l + 1;
            visited[arr[l]] = false;
        }
        System.out.println(answer);
    }
}
