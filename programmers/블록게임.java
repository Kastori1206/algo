package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 블록게임
 * https://programmers.co.kr/learn/courses/30/lessons/42894
 */
public class 블록게임 {
    public static void main(String[] args) {
//        int[][] board = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},{0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},{1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};
//        int[][] board = {
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {7, 7, 7, 0, 0, 0, 0, 0, 0, 0},
//                {6, 7, 0, 0, 0, 0, 0, 0, 0, 0},
//                {6, 0, 2, 0, 0, 0, 3, 0, 0, 0},
//                {6, 6, 2, 0, 0, 0, 3, 0, 0, 0},
//                {0, 4, 2, 2, 1, 3, 3, 5, 0, 0},
//                {4, 4, 4, 1, 1, 1, 5, 5, 5, 0}
//        };
        int[][] board = {{0, 0, 8, 0, 0, 9, 0, 0, 0, 0},
                        {0, 0, 8, 9, 9, 9, 0, 0, 0, 0},
                        {0, 0, 8, 8, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(board));
//        for (int[][] ints : d) { ;
//            for (int[] anInt : ints) {
//                System.out.print(Arrays.toString(anInt)+ " ");
//            }
//            System.out.println();
//        }
    }

    static int N;
    /*
    ㅁ
    ㅁㅁㅁ

        ㅁ
    ㅁㅁㅁ

    ㅁ
    ㅁ
    ㅁㅁ

      ㅁ
      ㅁ
    ㅁㅁ

      ㅁ
    ㅁㅁㅁ
     */
    static int[][][] d = {
            {
                    {0, 0}, {1, 0}, {1, 1}, {1, 2}
            },
            {
                    {0, 0}, {1, 0}, {1, -1}, {1, -2}
            },
            {
                    {0, 0}, {1, 0}, {2, 0}, {2, 1}
            },
            {
                    {0, 0}, {1, 0}, {2, 0}, {2, -1}
            },
            {
                    {0, 0}, {1, 0}, {1, -1}, {1, 1}
            }
    };

    public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] != 0) {
                    int dir = getDir(r, c, board[r][c], board);
                    if (dir != -1) {
                        if (check(r, c, dir, board)) {
                            cleanBlock(r, c, dir, board);
                            answer++;
                            r--;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static int getDir(int r, int c, int block, int[][] board) {
        for (int i = 0; i < 5; i++) {
            boolean flag = true;
            for (int j = 0; j < 4; j++) {
                int nr = r + d[i][j][0];
                int nc = c + d[i][j][1];
                if (!isIn(nr, nc)) {
                    flag = false;
                    break;
                }

                if (board[nr][nc] != block) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    private static boolean check(int r, int c, int dir, int[][] board) {

        switch (dir) {
            case 0:
                if (board[r][c + 1] == 0 && board[r][c + 2] == 0 && checkRow(r, c + 1, board) && checkRow(r, c + 2, board)) {
                    return true;
                }
                break;
            case 1:
                if (board[r][c - 1] == 0 && board[r][c - 2] == 0 && checkRow(r, c - 1, board) && checkRow(r, c - 2, board)) {
                    return true;
                }
                break;
            case 2:
                if (board[r][c + 1] == 0 && board[r + 1][c + 1] == 0 && checkRow(r, c + 1, board)) {
                    return true;
                }
                break;
            case 3:
                if (board[r][c - 1] == 0 && board[r + 1][c - 1] == 0 && checkRow(r, c - 1, board)) {
                    return true;
                }
                break;
            case 4:
                if (board[r][c + 1] == 0 && board[r][c - 1] == 0 && checkRow(r, c - 1, board) && checkRow(r, c + 1, board)) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static void cleanBlock(int r, int c, int dir, int[][] board) {
        for (int i = 0; i < 4; i++) {
            board[r + d[dir][i][0]][c + d[dir][i][1]] = 0;
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static boolean checkRow(int r, int c, int[][] board) {
        for (int i = r; i >= 0; i--) {
            if (board[i][c] != 0) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] board) {
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
