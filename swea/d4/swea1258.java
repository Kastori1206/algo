package swea.d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	@Override
	public int compareTo(Point o) {
		if((this.x*this.y)-(o.x*o.y)>0) {
			return 1;
		}else if((this.x*this.y)-(o.x*o.y)<0) {
			return -1;
		}else {
			return this.y-o.y;
		}
		
	}
	
}
public class swea1258 {

	static int N;
	static int[] dx= {0, 0, -1, 1};
	static int[] dy= {-1, 1, 0, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ;t<=T;t++) {
			N = sc.nextInt();
			int[][] map = new int[N][N];
			boolean[][] v = new boolean[N][N];
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt=0;
			ArrayList<Point> list = new ArrayList<>();
			for(int i =0;i<N;i++) {				
				for(int j =0;j<N;j++) {
					if(map[i][j]!=0 && !v[i][j]) {
						Point p = findXY(map,j,i);
						list.add(p);
						fillV(v,p,j,i);
						cnt++;
					}									
				}
			}
			Collections.sort(list);
			System.out.print("#"+t+ " "+cnt+" " );
			for(Point temp : list) {
				System.out.print(temp.y +" "+temp.x+" ");
			}
			System.out.println();
		}
	}	
	static void fillV(boolean[][] v,Point p,int x, int y) {
		for(int i =y;i<y+p.y;i++) {
			for(int j =x;j<x+p.x;j++) {				
				v[i][j] = true;
			}
		}
	}
	static Point findXY(int[][] map, int x ,int y) {
		int nx = 0, ny = 0;
		for(int i=x;i<N;i++) {
			if(map[y][i] ==0) {
				nx = i-x;
				break;
			}
		}
		for(int i=y;i<N;i++) {
			if(map[i][x]==0) {
				ny = i-y;
				break;
			}
		}
		if(nx == 0) {
			nx = N-x;			
		}
		if(ny==0) {
			ny =N-y;
		}
		Point p = new Point();
		p.x = nx;
		p.y = ny;
		return p;
	}
}
