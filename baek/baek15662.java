package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 톱니바퀴(2)
 * https://www.acmicpc.net/problem/15662
 */
public class baek15662 {
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //0 오, 4 왼
        int T = Integer.parseInt(br.readLine());
        arr = new int[T][8];

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            move(a, b);

            int c = b;
            //왼쪽 방향
            for (int j = a; j >= 1; j--) {
                if (arr[j][6 + c] == arr[j - 1][2]) {
                    break;
                }
                c = c * -1;
                move(j - 1, c);

            }
            c = b;
            //오른쪽 방향
            for (int j = a; j < T - 1; j++) {
                if (arr[j][2 + c] == arr[j + 1][6]) {
                    break;
                }
                c = c * -1;
                move(j + 1, c);
            }
        }
        int answer = 0;
        for (int i = 0; i < T; i++) {
            if (arr[i][0] == 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void move(int a, int b) {
        if (b == 1) {
            int temp = arr[a][7];

            for (int i = 7; i >= 1; i--) {
                arr[a][i] = arr[a][i - 1];
            }
            arr[a][0] = temp;
        } else {
            int temp = arr[a][0];
            for (int i = 0; i < 7; i++) {
                arr[a][i] = arr[a][i + 1];
            }
            arr[a][7] = temp;
        }
    }
}
