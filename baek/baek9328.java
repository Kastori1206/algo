package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 열쇠
 * https://www.acmicpc.net/problem/9328
 */
public class baek9328 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C, key, answer;
    static char[][] map;
    static List<Node>[] doors;
    static boolean[][] visited;

    static class Node {
        int r, c;

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
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new char[R + 2][C + 2];
            answer = 0;
            key = 0;
            doors = new ArrayList[26];

            for (int i = 0; i < 26; i++) {
                doors[i] = new ArrayList<>();
            }

            for (int r = 0; r < R + 2; r++) {
                if (r == 0 || r == R + 1) {
                    Arrays.fill(map[r], '.');
                    continue;
                }
                String str = br.readLine();
                for (int c = 0; c < C + 2; c++) {
                    if (c == 0 || c == C + 1) {
                        map[r][c] = '.';
                        continue;
                    }
                    map[r][c] = str.charAt(c - 1);
                }
            }

            String str = br.readLine();
            if (!str.equals("0")) {
                for (int i = 0; i < str.length(); i++) {
                    key |= (1 << (str.charAt(i) - 'a'));
                }
            }

            bfs(0, 0);
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void bfs(int r, int c) {
        visited = new boolean[R + 2][C + 2];
        Queue<Node> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Node(r, c));

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
                if (map[nr][nc] == '*') {
                    continue;
                }
                char ch = map[nr][nc];
                //문을 만났을 때
                if (ch >= 'A' && ch <= 'Z') {
                    int bit = (int) ch - 'A';
                    if ((key & (1 << bit)) != 0) {
                        map[nr][nc] = '.';
                        visited[nr][nc] = true;
                        q.offer(new Node(nr, nc));
                    } else {
                        doors[bit].add(new Node(nr, nc));
                    }
                }
                //열쇠를 만났을 때
                else if (ch >= 'a' && ch <= 'z') {
                    int bit = (int) ch - 'a';
                    key |= (1 << bit);
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                    //발견한 문들 중 열수있는 문 열기
                    for (Node node : doors[bit]) {
                        if (visited[node.r][node.c]) {
                            continue;
                        }
                        char nodeKey = (char) (bit + 'A');
                        if (map[node.r][node.c] != nodeKey) {
                            continue;
                        }

                        map[node.r][node.c] = '.';
                        visited[node.r][node.c] = true;
                        q.offer(new Node(node.r, node.c));
                    }
                } else {
                    if (ch == '$') {
                        answer++;
                        map[nr][nc] = '.';
                    }
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }

        }
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < R + 2 && c < C + 2;
    }
}
