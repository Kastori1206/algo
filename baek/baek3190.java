package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 뱀
 * https://www.acmicpc.net/problem/3190
 */
public class baek3190 {
    static class Snake {
        int r, c, d;//행 , 열 , 방향

        public Snake(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    //상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[N + 1][N + 1];
        boolean[][] visited = new boolean[N + 1][N + 1];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = true;
        }
        char[] cmd = new char[10000 + 1];
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            cmd[X] = C;
        }

        Deque<Snake> q = new ArrayDeque<>();
        q.offer(new Snake(1, 1, 1));
        visited[1][1] = true;
        int answer = 0;
        while (true) {
            answer++;
            Snake head = q.peekFirst();
            int d = head.d;

            //몸의 길이를 늘려 머리를 다음칸에 위치
            int nr = head.r + dr[d];
            int nc = head.c + dc[d];

            //벽에 부딪히면 끝
            if (!isIn(nr, nc)) {
                break;
            }
            //자기자신의 몸과 부딪히면 끝
            if (visited[nr][nc]) {
                break;
            }

            //이동한 칸에 사과가 없다면 꼬리를 줄여진다
            if (!map[nr][nc]) {
                Snake temp = q.pollLast();
                visited[temp.r][temp.c] = false;
            } else { //사과가 있다면 사과를 없앤다
                map[nr][nc] = false;
            }
            //시간에 방향 변환 명령어가 있으면 방향 변경
            if (cmd[answer] != ' ') {
                d = changDir(cmd[answer], d);
            }
            //머리 늘려준다
            q.offerFirst(new Snake(nr, nc, d));
            visited[nr][nc] = true;
        }
        System.out.println(answer);
    }

    public static int changDir(char C, int dir) {
        switch (C) {
            case 'L':
                dir--;
                if (dir < 0) {
                    dir = 3;
                }
                break;
            case 'D':
                dir++;
                if (dir > 3) {
                    dir = 0;
                }
                break;
        }
        return dir;
    }

    public static boolean isIn(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= N;
    }
}
