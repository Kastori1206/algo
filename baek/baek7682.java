package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 틱택토
 * https://www.acmicpc.net/problem/7682
 */
public class baek7682 {
    static int[][] arr;
    static int[][] dir = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };
    static Set<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new int[3][3];
        set = new HashSet<>();
        dfs(0);
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            sb.append(set.contains(input)? "valid" : "invalid").append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n){
        StringBuilder res = new StringBuilder();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (arr[r][c] == 1) {
                    res.append("X");
                } else if (arr[r][c] == 2) {
                    res.append("O");
                } else {
                    res.append(".");
                }
            }
        }
        for (int d = 0; d < 8; d++) {
            if (check(res.toString(), d)) {
                set.add(res.toString());
                return;
            }
        }
        if (n == 9) {
            set.add(res.toString());
            return;
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (arr[r][c] != 0) {
                    continue;
                }
                arr[r][c] = n % 2 + 1;
                dfs(n + 1);
                arr[r][c] = 0;
            }
        }
    }

    static boolean check(String str, int d) {
        if (str.charAt(dir[d][0]) == '.') {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (str.charAt(dir[d][0]) != str.charAt(dir[d][i])) {
                return false;
            }
        }
        return true;
    }
}

