package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

/**
 * 소가 길을 건너간 이유 6
 * https://www.acmicpc.net/problem/14466
 */
public class baek14466 {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            Node node = (Node) o;
            return r == node.r && c == node.c;
        }

    }
    static int N, K, R;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        List<Node>[][] info = new ArrayList[N + 1][N + 1];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                info[r][c] = new ArrayList<>();
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            info[r1][c1].add(new Node(r2, c2));
            info[r2][c2].add(new Node(r1, c1));
        }

        List<Node> cows = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
            cows.add(new Node(r, c));
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            Node cow = cows.get(i);
            boolean[][] visited = new boolean[N+1][N+1];
            boolean[][] cowContact = new boolean[K][K];

            Queue<Node> q = new LinkedList<>();
            q.offer(cow);
            visited[cow.r][cow.c] = true;

            while (!q.isEmpty()) {
                Node cur = q.poll();

                if (map[cur.r][cur.c] == 1) {
                    for (int j = i + 1; j < K; j++) {
                        Node next = cows.get(j);

                        if (next.equals(cur) ) {
                            cowContact[i][j] = true;
                            break;
                        }
                    }
                }
                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    if (info[cur.r][cur.c].contains(new Node(nr, nc))) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }

            for (int j = i + 1; j < K; j++) {
                if (!cowContact[i][j]) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isIn(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }
}
