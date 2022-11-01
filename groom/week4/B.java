package groom.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 단풍나무
 */
public class B {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0) {
                    rq.offer(r);
                    cq.offer(c);
                }
            }
        }
        int answer = 0;

        while (!rq.isEmpty()) {
            int size = rq.size();
            answer++;
            int[][] temp = new int[N][N];
            for (int i = 0; i < size; i++) {
                int r = rq.poll();
                int c = cq.poll();

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                        continue;
                    }
                    if (map[nr][nc] != 0) {
                        continue;
                    }
                    cnt++;
                }
                temp[r][c] = Math.max(map[r][c] - cnt, 0);

                if (temp[r][c] > 0) {
                    rq.offer(r);
                    cq.offer(c);
                }
            }
            map = temp;

        }
        System.out.println(answer);


    }
}
