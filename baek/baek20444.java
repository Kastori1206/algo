package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이와 가위
 * https://www.acmicpc.net/problem/20444
 */
public class baek20444 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long l = 0;
        long r = N / 2;

        String answer = "NO";
        while (l <= r) {
            long mid = (l + r) / 2;
            long res = (mid + 1) * ((N - mid) + 1);
            if (res > K) {
                r = mid - 1;
            } else if (res < K) {
                l = mid + 1;
            } else {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
    }


}
