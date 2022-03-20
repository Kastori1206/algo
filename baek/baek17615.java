package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 불 모으기
 * https://www.acmicpc.net/problem/17615
 */
public class baek17615 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int R = 0, B = 0;
        char[] balls = br.readLine().toCharArray();

        for (char ball : balls) {
            if (ball == 'R') {
                R++;
            } else {
                B++;
            }
        }

        int answer = Math.min(R, B);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (balls[i] != balls[0]) {
                break;
            }
            cnt++;
        }

        if (balls[0] == 'R') {
            answer = Math.min(answer, R - cnt);
        } else {
            answer = Math.min(answer, B - cnt);
        }

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] != balls[N - 1]) {
                break;
            }
            cnt++;
        }

        if (balls[N - 1] == 'R') {
            answer = Math.min(answer, R - cnt);
        } else {
            answer = Math.min(answer, B - cnt);
        }

        System.out.println(answer);
    }
}
