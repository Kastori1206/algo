package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 컨베이어 벨트 위의 로봇
 * https://www.acmicpc.net/problem/20055
 */
public class baek20055 {
    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N * 2 + 1][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N * 2; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        int t = 0;

        while (true) {
            if (check()) {
                break;
            }

            beltRoate();
            robotMove();

            if (arr[1][1] == 0 && arr[1][0] >= 1) {
                arr[1][0]--;            //내구도 감소
                arr[1][1] = 1;          //로봇 올림
            }
            t++;
        }

        System.out.println(t);
    }

    private static void robotMove() {
        for (int i = N - 1; i >= 1; i--) {
            //로봇이 있으면
            if (arr[i][1] == 0) {
                continue;
            }

            //다음 칸에 로봇이 있으면
            if (arr[i + 1][1] == 1) {
                continue;
            }

            //다음칸의 내구도가 1보다 작으면
            if (arr[i + 1][0] < 1) {
                continue;
            }
            //로봇 이동
            arr[i + 1][0]--;
            arr[i + 1][1] = 1;
            arr[i][1] = 0;
        }

        //마지막 칸에 로봇이 있으면 내리기
        arr[N][1] = arr[N][1] == 1 ? 0 : arr[N][1];
    }

    private static void beltRoate() {
        int[] temp = arr[N * 2];
        for (int i = N * 2 - 1; i >= 1; i--) {
            arr[i + 1] = arr[i];
        }
        arr[1] = temp;
        arr[N][1] = arr[N][1] == 1 ? 0 : arr[N][1];

    }

    private static boolean check() {
        int cnt = 0;
        for (int i = 1; i <= N * 2; i++) {
            if (arr[i][0] == 0) {
                cnt++;
            }
        }

        return cnt >= K;
    }
}
