package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 블록 이동하기
 * https://programmers.co.kr/learn/courses/30/lessons/60063
 */
public class 블록이동하기 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    static class Robot {
        //dir  0 가로 1 세로
        int r1, c1, r2, c2, dir, dist;

        public Robot(int r1, int c1, int r2, int c2, int dir, int dist) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.dir = dir;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "r1=" + r1 +
                    ", c1=" + c1 +
                    ", r2=" + r2 +
                    ", c2=" + c2 +
                    '}';
        }
    }

    static int R, C;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static int solution(int[][] board) {
        int answer = 0;
        Queue<Robot> q = new LinkedList<>();
        R = board.length;
        C = board.length;

        boolean[][][] visited = new boolean[R][C][2];

        q.offer(new Robot(0, 0, 0, 1, 0, 0));
        while (!q.isEmpty()) {
            Robot robot = q.poll();
            int r1 = robot.r1;
            int c1 = robot.c1;
            int r2 = robot.r2;
            int c2 = robot.c2;
            int dir = robot.dir;
            int dist = robot.dist;
            if ((r1 == R-1 && c1 == C-1) || (r2 == R-1 && c2 == C-1)) {
                answer = robot.dist;
                break;
            }
            if (!isIn(r1, c1) || !isIn(r2, c2)) {
                continue;
            }
            if (board[r1][c1] == 1 || board[r2][c2] == 1) {
                continue;
            }

            if (visited[r1][c1][dir] && visited[r2][c2][dir]) {
                continue;
            }

            visited[r1][c1][dir] = true;
            visited[r2][c2][dir] = true;

            for (int d = 0; d < 4; d++) {
                int nr1 = r1 + dr[d];
                int nc1 = c1 + dc[d];
                int nr2 = r2 + dr[d];
                int nc2 = c2 + dc[d];

                q.offer(new Robot(nr1, nc1, nr2, nc2, dir, dist + 1));
            }
            //회전
            //가로방향일때
            if (dir == 0) {
                if (r1 - 1 >= 0 && board[r1 - 1][c1] == 0 && board[r2 - 1][c2] == 0) {
                    q.offer(new Robot(r1, c1, r1 - 1, c1, 1, dist + 1));
                    q.offer(new Robot(r2, c2, r2 - 1, c2, 1, dist + 1));
                }
                if (r1 + 1 < R && board[r1 + 1][c1] == 0 && board[r2 + 1][c2] == 0) {
                    q.offer(new Robot(r1, c1, r1 + 1, c1, 1, dist + 1));
                    q.offer(new Robot(r2, c2, r2 + 1, c2, 1, dist + 1));
                }
            }
            //세로방향
            else {
                if (c1 - 1 >= 0 && board[r1][c1-1]==0 && board[r2][c2-1]==0) {
                    q.offer(new Robot(r1, c1, r1, c1 - 1, 0, dist + 1));
                    q.offer(new Robot(r2, c2, r2, c2 - 1, 0, dist + 1));
                }
                if (c1 + 1 < C && board[r1][c1+1] == 0 && board[r2][c2+1]==0) {
                    q.offer(new Robot(r1, c1, r1, c1 + 1, 0, dist + 1));
                    q.offer(new Robot(r2, c2, r2, c2 + 1, 0, dist + 1));
                }
            }
        }
        return answer;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
