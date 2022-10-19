package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 싸움땅
 * https://www.codetree.ai/frequent-problems/battle-ground/description
 */
public class 싸움땅 {
    static class Node{
        int n;
        int r;
        int c;
        int d;  //방향
        int s;  //능력
        int g;  //총

        public Node(int n, int r, int c, int d, int s) {
            this.n = n;
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "n=" + n +
                    ", r=" + r +
                    ", c=" + c +
                    ", d=" + d +
                    ", s=" + s +
                    ", g=" + g +
                    '}';
        }
    }
    static int n,m, k;
    static int[] dr = {-1, 0, 1, 0}; //상 우 하 좌
    static int[] dc = {0, 1, 0, -1};
    static PriorityQueue<Integer>[][] map;
    static int[][] visited;

    static Node[] players;
    static int[] answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new PriorityQueue[n][n];
        players = new Node[m];
        answer = new int[m];
        visited = new int[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                map[r][c] = new PriorityQueue<>((o1,o2)->-Integer.compare(o1,o2));
            }
        }
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c].offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players[i] = new Node(i + 1, r, c, d, s);

            visited[r][c] = i + 1;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < players.length; j++) {
                Node p1 = players[j];
                visited[p1.r][p1.c] = 0;
                //이동
                move(p1);
                int r = p1.r;
                int c = p1.c;
                int idx = visited[r][c];
                //다른 사람이 있을 경우
                if (idx != 0) {
                    fight(p1, players[idx - 1]);
                } else {
                    //사용자가 가진 총이 더 낮을 경우
                    if (!map[r][c].isEmpty() && p1.g < map[r][c].peek()) {
                        int g = map[r][c].poll();
                        map[r][c].offer(p1.g);
                        p1.g = g;
                    }
                    visited[r][c] = p1.n;
                }
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private static void print() {
        for (int r = 0; r < n; r++) {
            System.out.println(Arrays.toString(visited[r]));
        }
    }

    static void win(Node p) {
        int r = p.r;
        int c = p.c;

        if (map[r][c].peek() > p.g) {
            int g = map[r][c].poll();
            map[r][c].offer(p.g);
            p.g = g;
        }

        visited[p.r][p.c] = p.n;
    }

    static void lose(Node p) {
        int r = p.r;
        int c = p.c;
        int d = p.d;

        //총 반납
        map[r][c].offer(p.g);
        p.g = 0;

        d = getDir(r, c, d);
        r = r + dr[d];
        c = c + dc[d];
        if (!map[r][c].isEmpty()) {
            p.g = map[r][c].poll();
        }
        p.r = r;
        p.c = c;
        p.d = d;
        visited[p.r][p.c] = p.n;
    }

    static int getDir(int r, int c, int d) {
        for (int i = d; i < d + 4; i++) {
            int nr = r + dr[i % 4];
            int nc = c + dc[i % 4];

            if (!isIn(nr, nc)) {
                continue;
            }
            if (visited[nr][nc] == 0) {
                return i % 4;
            }
        }
        return -1;
    }
    private static void fight(Node p1, Node p2) {
        int sum1 = p1.g + p1.s;
        int sum2 = p2.g + p2.s;

        if (sum1 > sum2) {
            answer[p1.n - 1] += sum1 - sum2;
            lose(p2);
            win(p1);
        } else if (sum1 < sum2) {
            answer[p2.n - 1] += sum2 - sum1;
            lose(p1);
            win(p2);
        } else {
            if (p1.s < p2.s) {
                answer[p2.n - 1] += sum2 - sum1;
                lose(p1);
                win(p2);
            } else {
                answer[p1.n - 1] += sum1 - sum2;
                lose(p2);
                win(p1);
            }
        }
    }

    private static void move(Node p) {
        int r = p.r;
        int c = p.c;
        int d = p.d;

        if (!isIn(r + dr[d], c + dc[d])) {
            d = (d + 2) % 4;
        }

        p.r = r + dr[d];
        p.c = c + dc[d];
        p.d = d;

    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}
