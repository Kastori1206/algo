package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 222-풀링
 * https://www.acmicpc.net/problem/17829
 */
public class baek17829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while (N != 1) {
            for (int r = 0; r < N; r += 2) {
                for (int c = 0; c < N; c += 2) {
                    int[] temp = {arr[r][c], arr[r][c + 1], arr[r + 1][c], arr[r + 1][c + 1]};
                    Arrays.sort(temp);
                    arr[r / 2][c / 2] = temp[2];
                }
            }
            N /= 2;
        }

        System.out.println(arr[0][0]);
    }

}
