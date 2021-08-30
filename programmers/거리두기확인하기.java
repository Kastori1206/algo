package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 거리두기 확인하기
 * https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class 거리두기확인하기 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}, {"PXOOO", "OOOOO", "PXOOO", "OOOOO", "OOOPO"}};
        System.out.println(Arrays.toString(solution(places)));
    }
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Node{
        int r, c ,dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", dist=" + dist +
                    '}';
        }
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int t = 0; t < places.length; t++) {
            int flag = 1;
            out:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    char ch = places[t][r].charAt(c);
                    if (ch == 'P') {
                        flag = check(r, c, places[t]);
                        if (flag == 0) {
                            break out;
                        }
                    }
                }
            }
            answer[t] = flag;
        }
        return answer;
    }

    private static int check(int r, int c, String[] map) {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[5][5];
        visited[r][c] = true;
        q.offer(new Node(r, c, 0));
        int res = 1;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.dist == 2|| res == 0)  {
                break;
            }
            for (int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }
                if (map[nr].charAt(nc) == 'X') {
                    continue;
                }
                if (map[nr].charAt(nc) == 'P') {
                    res = 0;
                }else{
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc, n.dist + 1));
                }
            }
        }

        return res;
    }

    private static boolean isIn(int r, int c) {
        return r>=0 && c>=0 && r<5 && c<5;
    }
}