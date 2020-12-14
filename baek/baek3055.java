package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;
/*
 * 3055.탈출
 * https://www.acmicpc.net/problem/3055
 */
public class baek3055 {
   static int R,C,answer;
   static char[][] map;
   static int[] dr = {-1,1,0,0};
   static int[] dc = {0,0,-1,1};
   static Queue<Point> q, water;
   static Point S,D;
   static boolean[][] visited;
   static class Point{
      int r,c;

      public Point(int r, int c) {      
         this.r = r;
         this.c = c;         
      }

      @Override
      public String toString() {
         return "Point [r=" + r + ", c=" + c + "]";
      }   
      
   }
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      R = Integer.parseInt(st.nextToken());
      C = Integer.parseInt(st.nextToken());
      
      map = new char[R][C];
      
      answer = -1;
      water = new LinkedList<>();
      q = new LinkedList<>();
      
      for(int r = 0 ; r<R;r++) {
         String temp = br.readLine();
         for(int c = 0 ;c<C;c++) {
            map[r][c] = temp.charAt(c);
            if(map[r][c]=='S') {
               q.add(new Point(r,c));
            }else if(map[r][c]=='*') {
               water.add(new Point(r,c));
            }
         }         
      }
      
      bfs();
      
      if(answer == -1 ) {
         System.out.println("KAKTUS");
      }else {
         System.out.println(answer);
      }      
   }
   static void print() {
      for(int r = 0 ;r<R;r++) {
         for(int c = 0;c<C;c++) {
            System.out.print(map[r][c] + " ");
         }
         System.out.println();
      }
   }
   static void bfs() {
      for(answer = 1; ; answer++) {         
         int size = water.size();
         for(int i =0;i<size;i++) {
            Point p = water.poll();
            for(int d = 0; d<4;d++) {
               int nr = p.r + dr[d];
               int nc = p.c + dc[d];
               if(!isIn(nr, nc)) {
                  continue;
               }
               if(map[nr][nc] == '.') {
                  water.add(new Point(nr,nc));
                  map[nr][nc] = '*';
               }
            }         
         }         
         size = q.size();
         if(size==0) {
            answer = -1;
            return;
         }
         for(int i =0;i<size;i++) {
            Point p = q.poll();
            
            for(int d = 0; d<4;d++) {
               int nr = p.r + dr[d];
               int nc = p.c + dc[d];
               
               if(isIn(nr, nc)) {
                  if(map[nr][nc] == 'D') {
                     return;
                  }
                  if(map[nr][nc] == '.') {
                     map[nr][nc] = 'S';
                     q.add(new Point(nr,nc));
                  }
               }
            }   
         }
      }
   }
   static boolean isIn(int r, int c) {      
      return r>=0 && c>= 0 && r<R && c<C;
   }
   
}