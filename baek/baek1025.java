package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제곱수 찾기
 * https://www.acmicpc.net/problem/1025
 */
public class baek1025 {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int r = 0; r < N; r++) {
            String temp = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = temp.charAt(c) - '0';
            }
        }
        int answer = -1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int rr = -N + 1; rr < N; rr++) {
                    for (int cc = -M + 1; cc < M; cc++) {
                        if (rr == 0 && cc == 0) {
                            continue;
                        }

                        int a = r;
                        int b = c;

                        String num = "";
                        while (isIn(a, b)) {
                            num += arr[a][b];
                            answer = Math.max(answer, getSquare(Integer.parseInt(num)));
                            a += rr;
                            b += cc;
                        }
                    }
                }
            }
        }
        if (N == 1 && M == 1) {
            System.out.println(getSquare(arr[0][0]));
        } else {
            System.out.println(answer);
        }

    }

    static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static int getSquare(int num) {
        int root = (int) Math.sqrt(num);

        return root * root == num ? num : -1;
    }
}
