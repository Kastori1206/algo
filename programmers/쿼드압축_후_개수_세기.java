package programmers;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class 쿼드압축_후_개수_세기 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(solution(arr)));
        arr = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(solution(arr)));

    }

    static int[] answer;

    static public int[] solution(int[][] arr) {
        answer = new int[2];
        dfs(arr, 0, 0, arr.length);
        return answer;
    }

    static void dfs(int[][] arr, int sr, int sc, int len) {
        if (check(arr, sr, sc, len)) {
            answer[arr[sr][sc]]++;
            return;
        }
        if (len == 1) {
            answer[arr[sr][sc]]++;
            return;
        }
        dfs(arr, sr, sc, len / 2);
        dfs(arr, sr + len / 2, sc, len / 2);
        dfs(arr, sr, sc + len / 2, len / 2);
        dfs(arr, sr + len / 2, sc + len / 2, len / 2);
    }

    static boolean check(int[][] arr, int sr, int sc, int len) {
        int temp = arr[sr][sc];
        for (int r = sr; r < sr + len; r++) {
            for (int c = sc; c < sc + len; c++) {
                if (arr[r][c] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
