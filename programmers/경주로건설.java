package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{0,0,0}, {0,0,0},{0,0,0}};
        System.out.println(solution(board));
    }
    static class Point{
        int r, c, d ,cost;

        Point(int r, int c,int d,int cost){
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
    static public int solution(int[][] board) {
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int N = board.length;
        int[][] costs = new int[N][N];

        Queue<Point> pq = new LinkedList<>();
        pq.add(new Point(0,0,-1,0));
        while(!pq.isEmpty()){
            Point p = pq.poll();

            for(int i = 0; i<4;i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (!isIn(nr,nc,N)){
                    continue;
                }
                if(board[nr][nc]==1){
                    continue;
                }
                int cost = 0;
                if(p.d == i || p.d == -1){
                    cost = p.cost + 100;
                }else{
                    cost = p.cost + 600;
                }

                if(costs[nr][nc] != 0){
                    if(cost <= costs[nr][nc]){
                        pq.add(new Point(nr,nc,i,cost));
                        costs[nr][nc] =cost;
                    }
                }else {
                    costs[nr][nc] = cost;
                    pq.add(new Point(nr, nc, i,cost));


                }
            }
        }
        return costs[N-1][N-1];
    }

    static boolean isIn(int r, int c, int N){
        return r>=0&&c>=0&&r<N&&c<N;
    }
}