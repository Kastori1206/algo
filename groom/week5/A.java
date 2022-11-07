package groom.week5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 1) {
                    list.add(new int[]{r, c});
                }
            }
        }

        int answer = 0;
        for (int[] start : list) {
            if (bfs(start)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static boolean bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(start);
        visited[start[0]][start[1]] = true;
        int cnt = 0;
        while (!q.isEmpty() && cnt <=M) {
            cnt++;
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if (map[r][c] == 2) {
                    return true;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (!isIn(nr, nc)) {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
