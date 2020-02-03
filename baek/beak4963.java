package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class beak4963 {
	//상,하,좌,우,우상,우하,좌상,좌하
	static int[] dx = {0,0,-1,1,1,1,-1,-1}; 
	static int[] dy = {-1,1,0,0,-1,1,1,-1};
	static class Pair {
		int x;
		int y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {			
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if(w == 0 && h == 0 ) {
				break;
			}
			int cnt =0;
			int[][] map = new int [h][w];
			int[][] v = new int [h][w];
			for(int i =0;i<h;i++) {
				for(int j =0;j<w;j++) {
					map[i][j] = sc.nextInt();
				}
			}			
			
			for(int i =0;i<h;i++) {
				for(int j =0;j<w;j++) {
					if(v[i][j]!=0 || map[i][j] ==0) {
						continue;
					}					
					//bfs(j,i,++cnt,map,v,h,w);
					dfs(map,v,j,i,h,w,++cnt);
				}
			}
			System.out.println(cnt);
		}
	}
	static void dfs(int[][]map, int[][] v, int x, int y ,int h, int w,int cnt) {
		v[y][x] = cnt;
		
		for(int i =0;i<8;i++) {
			int nx= x+dx[i]; int ny = y+dy[i];
			if(nx>=w || nx<0|| ny>=h || ny<0) {
				continue;				
			}
			if(map[ny][nx]==0) {
				continue;
			}
			if(v[ny][nx]!=0) {
				continue;
			}				
			dfs(map,v,nx,ny,h,w,cnt);
		}
	}
	static void bfs(int x, int y,int cnt,int[][] map, int[][] v, int h, int w) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x,y));
		
		Pair temp;
		while(!q.isEmpty()) {
			temp = q.poll();
			v[temp.y][temp.x]=cnt; 
			for(int i =0;i<8;i++) {
				int nx = temp.x+dx[i]; int ny = temp.y+dy[i];
				if(nx>=w || nx<0|| ny>=h || ny<0) {
					continue;				
				}
				if(map[ny][nx]==0) {
					continue;
				}
				if(v[ny][nx]!=0) {
					continue;
				}				
				q.offer(new Pair(nx,ny));
			}
		}		
	}

}
