package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사다리
 * https://www.acmicpc.net/problem/2022
 */
public class baek2022 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double s = 0;
        double e = Math.min(x, y);

        while (e - s >= 0.001) {
            double mid = (s + e) / 2;

            double res = calc(x, y, mid);

            if (res >= c) {
                s = mid;
            } else {
                e = mid;
            }
        }
        System.out.println(String.format("%.3f", e));
    }

    private static double calc(double x, double y, double mid) {
        double h1 = Math.sqrt((x * x) - (mid * mid));
        double h2 = Math.sqrt((y * y) - (mid * mid));

        return (h1 * h2) / (h1 + h2);
    }
}
