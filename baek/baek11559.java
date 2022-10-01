package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Puyo Puyo
 * https://www.acmicpc.net/problem/11559
 */
public class baek11559 {
    static class Node implements Comparable<Node>{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return -Integer.compare(r, o.r);

        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int R =12 , C = 6;
    static Queue<Node> puyos;
    static PriorityQueue<Node> newPuyos;
    static boolean[][] visited;
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[R][C];
        puyos = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if (map[r][c] != '.') {
                    puyos.offer(new Node(r, c));
                }
            }
        }

        int answer = 0;

        while (true) {
            boolean flag = false;
            int size = puyos.size();
            visited = new boolean[R][C];
            newPuyos = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                Node start = puyos.poll();
                if (visited[start.r][start.c]) {
                    continue;
                }
                flag |= bfs(start);
            }
            if (!flag) {
                break;
            }

            move();
            answer++;
        }
        System.out.println(answer);
        
    }

    private static void move() {
        while (!newPuyos.isEmpty()) {
            Node cur = newPuyos.poll();

            char color = map[cur.r][cur.c];
            map[cur.r][cur.c] = '.';
            int nr = cur.r;
            while (true) {
                if (nr >= R) {
                    break;
                }
                if (map[nr][cur.c] != '.') {
                    break;
                }
                nr++;
            }
            nr--;
            map[nr][cur.c] = color;
            cur.r = nr;
            puyos.offer(cur);
        }
    }

    static boolean bfs(Node start) {
        char color = map[start.r][start.c];

        List<Node> temp = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        temp.add(start);
        q.offer(start);
        visited[start.r][start.c] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (visited[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] != color || map[nr][nc] == '.') {
                    continue;
                }
                visited[nr][nc] = true;
                Node node = new Node(nr, nc);
                q.offer(node);
                temp.add(node);
            }
        }
        if (temp.size() >= 4) {
            for (Node node : temp) {
                map[node.r][node.c] = '.';
            }
            return true;
        } else {
            for (Node node : temp) {
                newPuyos.offer(node);
            }
            return false;
        }

    }
    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    static void print() {
        for (int r = 0; r < R; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }
}
