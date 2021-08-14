package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사분면
 * https://www.acmicpc.net/problem/1891
 */
public class baek1891 {
    static int[] dy = {0, 1, 1, 0, 0};
    static int[] dx = {0, 1, 0, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        String num = st.nextToken();

        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        StringBuilder answer = new StringBuilder();

        long r = 0, c = 0;
        long size = (long) Math.pow(2, d);
        long temp = (long) Math.pow(2, d - 1);
        for (int i = 0; i < d; i++) {
            int quadrant = num.charAt(i) - '0';
            r += dy[quadrant] * temp;
            c += dx[quadrant] * temp;
            temp /= 2;
        }
        r += y;
        c += x;
        if (!isIn(r, c, size)) {
            System.out.println(-1);
            return;
        }
        temp = (long) Math.pow(2, d - 1);
        for (int i = 0; i < d; i++) {
            long ny = r / temp;
            long nx = c / temp;
            for (int j = 1; j <= 4; j++) {
                if (ny == dy[j] && nx == dx[j]) {
                    answer.append(j);
                    break;
                }
            }
            r %= temp;
            c %= temp;
            temp /= 2;
        }
        System.out.println(answer.toString());
    }

    public static boolean isIn(long r, long c, long size) {
        return r >= 0 && c >= 0 && r < size && c < size;
    }
}




