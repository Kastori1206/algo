package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 미네랄
 * https://www.acmicpc.net/problem/2933
 */
public class baek2933 {
    static class Mineral{
        int r,c;

        public Mineral(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Mineral{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
    static int R, C, N;
    static char[][] map;
    static int[][] clusters;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String temp = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = temp.charAt(c);
            }
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int r = Integer.parseInt(st.nextToken());
            hit(r,i%2==0? 0:1);
            setCluster();
        }
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }

    private static void setCluster() {
        clusters = new int[R][C];

        int num = 1;
        for(int r = 0;r<R;r++){
            for(int c=0;c<C;c++){
                if(map[r][c] =='x' && clusters[r][c] ==0){
                    if (check(r, c, num)) {
                        return;
                    }
                    num++;
                }
            }
        }
    }

    /**
     *
     * @param r   row
     * @param c   col
     * @param num 구역 번호
     * @return 클러스터가 떨어져있으면 true 없으면 false;
     */
    private static boolean check(int r, int c, int num) {
        int bottom = -1;
        Queue<Mineral> q = new LinkedList<>();
        List<Mineral> minerals = new ArrayList<>();

        q.add(new Mineral(r, c));
        clusters[r][c] = num;

        while (!q.isEmpty()) {
            Mineral m = q.poll();
            bottom = Math.max(bottom, m.r);

            for(int d = 0;d<4;d++){
                int nr = m.r + dr[d];
                int nc = m.c + dc[d];

                if (!isIn(nr, nc)) {
                    continue;
                }
                if (map[nr][nc] != 'x') {
                    continue;
                }
                if (clusters[nr][nc] != 0) {
                    continue;
                }
                clusters[nr][nc] = num;
                q.add(new Mineral(nr, nc));
            }
            minerals.add(m);
        }

        if (bottom != R - 1) {
            move(minerals);
            return true;
        }
        return false;
    }

    /**
     * 이동
     * @param minerals 클러스터의 리스트
     */
    private static void move(List<Mineral> minerals) {
        int h = 1;
        for (Mineral mineral : minerals) {
            map[mineral.r][mineral.c] = '.';
        }
        int min = R;
        for (Mineral m : minerals) {
            min = Math.min(min, R - m.r - 1);
            for(int r = m.r+1; r<R;r++){
                if(map[r][m.c]=='x'){
                    min = Math.min(min,r-m.r-1);
                    break;
                }
            }
        }
        for (Mineral m : minerals) {
            map[m.r+min][m.c] = 'x';
        }

    }

    /**
     *
     * @param r       높이
     * @param dir     방향 0-> 왼쪽 1->오른쪽
     */
    private static void hit(int r, int dir) {
        if(dir==0){
            for(int c = 0;c<C;c++){
                if (map[R - r][c] == 'x') {
                    map[R-r][c] ='.';
                    return;
                }
            }
        }else{
            for(int c = C-1;c>=0;c--){
                if (map[R - r][c] == 'x') {
                    map[R-r][c] ='.';
                    return;
                }
            }
        }
    }

    /**
     *
     * @param r row
     * @param c col
     * @return  맵의 범위 안에 있으면 true 없으면 false
     */
    public static boolean isIn(int r, int c){
        return r>=0 && c>=0 && r<R &&c<C;
    }
}

/**
 * 6 6 4 3 1
 * 012345678
 * ........ 8 0
 * ........ 7 1
 * .....x.. 6 2
 * ...xxx.. 5 3
 * ...xx... 4 4
 * ..x.xx.. 3 5
 * ..x...x. 2 6
 * .xxx..x. 1 7
 */

/**
 * 10 10
 * ..........
 * ...xxxxxx.
 * ....x...x.
 * xxxxxx..x.
 * x.......x.
 * x..xxxxxx.
 * x.........
 * x.........
 * x.........
 * x.........
 * 1
 * 8
 */