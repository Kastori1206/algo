package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 골드바흐 파티션
 * https://www.acmicpc.net/problem/17103
 */
public class baek17103 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = 1000000;

        boolean[] prime = new boolean[max + 1];

        prime[0] = prime[1] = true;
        for (int i = 2; i *i <= max; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i = 2; i <= N/2; i++) {
                if (!prime[i] && !prime[N - i]) {
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
