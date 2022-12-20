package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 매직 스타
 * https://www.acmicpc.net/problem/3967
 */
public class baek3967 {
    static boolean flag;
    static boolean[] check;
    static char[][] arr;
    static int cnt;
    static List<int[]> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][9];

        check = new boolean[13];
        cnt = 0;

        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = input.charAt(j);

                if (arr[i][j] >= 'A' && arr[i][j] <= 'L') {
                    check[arr[i][j] - 'A'] = true;
                } else if (arr[i][j] == 'x') {
                    list.add(new int[]{i, j});
                    cnt++;
                }
            }
        }

        dfs(0, 0);
    }

    static void dfs(int idx, int n) {
        if (cnt == n) {
            if (calc()) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(arr[i][j]);
                    }
                    sb.append("\n");
                }
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < 12; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            int r = list.get(idx)[0];
            int c = list.get(idx)[1];
            arr[r][c] = (char) (i + 'A');
            dfs(idx + 1, n + 1);
            arr[r][c] = 'x';
            check[i] = false;
        }
    }

    static boolean calc() {
        if ((arr[0][4] - 'A' + 1) + (arr[1][3] - 'A' + 1) + (arr[2][2] - 'A' + 1) + (arr[3][1] - 'A' + 1) != 26)
            return false;
        if ((arr[0][4] - 'A' + 1) + (arr[1][5] - 'A' + 1) + (arr[2][6] - 'A' + 1) + (arr[3][7] - 'A' + 1) != 26)
            return false;
        if ((arr[1][1] - 'A' + 1) + (arr[1][3] - 'A' + 1) + (arr[1][5] - 'A' + 1) + (arr[1][7] - 'A' + 1) != 26)
            return false;
        if ((arr[3][1] - 'A' + 1) + (arr[3][3] - 'A' + 1) + (arr[3][5] - 'A' + 1) + (arr[3][7] - 'A' + 1) != 26)
            return false;
        if ((arr[4][4] - 'A' + 1) + (arr[3][3] - 'A' + 1) + (arr[2][2] - 'A' + 1) + (arr[1][1] - 'A' + 1) != 26)
            return false;
        if ((arr[4][4] - 'A' + 1) + (arr[3][5] - 'A' + 1) + (arr[2][6] - 'A' + 1) + (arr[1][7] - 'A' + 1) != 26)
            return false;

        return true;
    }

    static void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
