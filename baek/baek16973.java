package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 직사각형 탈출
 * https://www.acmicpc.net/problem/16973
 */

public class baek16973 {
    static int N,M,W,H,Sr,Sc,Fr,Fc;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Point> wall ;
    static class Point{
        int r , c, cnt;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        wall = new ArrayList<>();

        for(int r = 1 ; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1){
                    wall.add(new Point(r,c));
                    visited[r][c] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        visited[Sr][Sc] = true;
        q.offer(new Point(Sr, Sc,0));

        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.r == Fr && p.c == Fc){
                answer = Math.min(answer, p.cnt);
                break;
            }
            for(int d=0;d<4;d++){
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                if(!isIn(nr, nc)){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                if(!check(nr,nc)){
                    continue;
                }
                visited[nr][nc] = true;
                q.offer(new Point(nr,nc,p.cnt+1));
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    public static boolean isIn(int r, int c){

        return r>=1 && r+H-1<=N && c>=1 && c+W-1 <=M;
    }

    public static boolean check(int r, int c){
       for(Point p : wall){
           if(p.r >= r && p.r < r+H && p.c >= c && p.c < c+W){
               return false;
           }
       }
       return true;
    }
}
