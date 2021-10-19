package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스타트 택시
 * https://www.acmicpc.net/problem/19238
 */
public class baek19238 {
    static int N, M, K, cnt;
    static int[][] map, dist, persons;
    static boolean[][] visited;
    static boolean[] check;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c, v;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", v=" + v +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        persons = new int[M + 1][4];
        check = new boolean[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            persons[i] = new int[]{sr, sc, er, ec};
        }
        cnt = 0;
        boolean flag = true;
        while (true) {
            //모든 승객을 태우고 이동 했으면
            if (cnt == M) {
                break;
            }
            //손님 찾고 이동 하기
            int person = find(start);

            //손님 태울수 없거나 연료가 없으면
            if (person == -1 || K < 0) {
                flag = false;
                break;
            }

            int sr = persons[person][0];
            int sc = persons[person][1];
            int er = persons[person][2];
            int ec = persons[person][3];
            start = new Node(sr, sc);
            Node end = new Node(er, ec);

            //손님의 도착지로 이동하기
            int d = move(start, end);

            //도착지로 이동 못하거나 도착 했을 때 연료가 0보다 작으면
            if (d == 0 || K - d < 0) {
                flag = false;
                break;
            }
            start = end;

            K += d;
            cnt++;
        }
        if (flag) {
            System.out.println(K);
        } else {
            System.out.println(-1);
        }
    }

    static int move(Node start, Node end) {
        bfs(start);
        return dist[end.r][end.c];
    }

    //손님 찾고 이동 하기
    static int find(Node start) {
        bfs(start);

        int min = Integer.MAX_VALUE;
        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            if (check[i]) {
                continue;
            }
            int r = persons[i][0];
            int c = persons[i][1];
            int d = dist[r][c];

            if (d == 0 && (r != start.r || c != start.c)) {
                continue;
            }
            if (min > d) {
                list = new ArrayList<>();
                list.add(new Node(r, c, i));
                min = d;
            } else if (min == d) {
                list.add(new Node(r, c, i));
            }
        }
        //태울 승객이 없으면
        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        int res = -1;
        if (list.size() > 1) {
            Collections.sort(list, (o1, o2) -> {
                if (o1.r == o2.r) {
                    return Integer.compare(o1.c, o2.c);
                }
                return Integer.compare(o1.r, o2.r);
            });
        }
        res = list.get(0).v;

        //손님까지 이동 한 후 연료 계산
        int d = dist[persons[res][0]][persons[res][1]];
        K -= d;
        check[res] = true;
        return res;
    }

    //전체 맵의 거리구하기
    static void bfs(Node start) {
        dist = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
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
                    if (map[nr][nc] == 1) {
                        continue;
                    }
                    dist[nr][nc] = dist[cur.r][cur.c] + 1;
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }

    static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(dist[i][j] + " ");

            }
            System.out.println();
        }
    }
}
