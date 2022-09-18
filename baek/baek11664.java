package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선분과 점
 * https://www.acmicpc.net/problem/11664
 */
public class baek11664 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        double min = 987654321;
        double lx = arr[0][0];
        double ly = arr[0][1];
        double lz = arr[0][2];
        double rx = arr[1][0];
        double ry = arr[1][1];
        double rz = arr[1][2];

        int cnt = 10000000;

        while (cnt-- > 0) {
            double mx = (lx + rx) / 2;
            double my = (ly + ry) / 2;
            double mz = (lz + rz) / 2;

            double lres = getDist(lx, ly, lz);
            double res = getDist(mx, my, mz);
            double rres = getDist(rx, ry, rz);

            if (Math.abs(res - min) < 0.00000000001) {
                break;
            }

            if (res < min) {
                min = res;
            }
            if (rres < lres) {
                lx = mx;
                ly = my;
                lz = mz;
            } else {
                rx = mx;
                ry = my;
                rz = mz;
            }
        }
        System.out.printf("%.10f%n", min);
    }

    static double getDist(double x, double y, double z) {
        double a = x - arr[2][0];
        double b = y - arr[2][1];
        double c = z - arr[2][2];
        return Math.sqrt(a * a + b * b + c * c);
    }
}
