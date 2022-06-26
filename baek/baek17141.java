package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연구소 2
 * https://www.acmicpc.net/problem/17141
 */
public class baek17141 {
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, M, blank, answer, res;
    static int[][] map;
    static List<Node> virus;
    static boolean[] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        virus = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    virus.add(new Node(r, c));
                    map[r][c] = 0;
                }
            }
        }
        answer = Integer.MAX_VALUE;

        visited = new boolean[virus.size()];


        combi(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer - 1);

    }
    static void combi(int depth, int start) {
        if (depth == M) {
            bfs();
            answer = Math.min(answer, res);
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            visited[i] = true;
            combi(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        int[][] temp = new int[N][N];
        int[][] time = new int[N][N];

        for (int r = 0; r < N; r++) {
            temp[r] = map[r].clone();
        }

        for (int i = 0; i < virus.size(); i++) {
            if (!visited[i]) {
                continue;
            }
            int r = virus.get(i).r;
            int c = virus.get(i).c;

            q.offer(virus.get(i));
            temp[r][c] = 0;
            time[r][c] = 1;
        }

        res = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;
            res = Math.max(res, time[r][c]);

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (temp[nr][nc] != 0) {
                    continue;
                }
                if (time[nr][nc] != 0) {
                    continue;
                }

                q.offer(new Node(nr, nc));
                temp[nr][nc] = 2;
                time[nr][nc] = time[r][c] + 1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (temp[i][j] == 0 && time[i][j] == 0) {
                    res = Integer.MAX_VALUE;
                    return;
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
