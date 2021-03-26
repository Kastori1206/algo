package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 퍼즐
 * https://www.acmicpc.net/problem/1525
 */
public class baek1525 {
    static class Point{
        int r, c,cnt;

        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[3][3];
        Point start = null;
        for(int r =0;r<3;r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0;c<3;c++){
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;
                if(num ==0){
                    start = new Point(r,c,0);
                }

            }
        }


    }
}
