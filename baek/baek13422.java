package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 도둑
 * https://www.acmicpc.net/problem/13422
 */
public class baek13422 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            if (N == M) {
                sb.append(sum < K ? 1 : 0);
            } else {
                int answer = 0;
                int l = 0, r = M - 1;
                sum = 0;
                for (int i = 0; i <= r; i++) {
                    sum += arr[i];
                }
                while (l < N) {
                    if (sum < K) {
                        answer++;
                    }
                    sum -= arr[l++];
                    r++;
                    sum += arr[r % N];
                }
                sb.append(answer);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
