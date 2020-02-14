package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	int day ;
	Point(int x, int y,int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class baek7576 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int result;
	static Queue<Point> qlist = new LinkedList<>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int[][]map = new int[n][m];
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1) {
					qlist.offer(new Point(j,i,0));					
				}
			}
		}
		result =0;
		while(!qlist.isEmpty()) {
			Point temp = qlist.poll();			
			bfs(map,temp.x,temp.y,n,m,temp.day);			
			
		}
	
		for(int i=0;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(map[i][j] ==0) {
					System.out.println(-1);
					return;
				}
				
			}
		}
		System.out.println(result);
		
		
	}//main
	static void bfs(int[][] map,int x, int y,int n, int m,int day) {
		if(result < day) {
			result = day;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isBound(nx, ny, n, m)) {
				continue;
			}
			if(map[ny][nx] != 0) {
				continue;
			}
			qlist.offer(new Point(nx,ny,day+1));
			map[ny][nx] =day+1;				
			
		}		
	}
	static boolean isBound(int x,int y, int n, int m) {
		if(x<0||x>=m || y<0|| y>=n) {			
			return false;
		}
		return true;
	}
}
