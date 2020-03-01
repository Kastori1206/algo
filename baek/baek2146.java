package baek;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 2146.다리만들기
 * https://www.acmicpc.net/problem/2146
 */

public class baek2146 {
	static int[][] map;
	static int[][] map1;
	static boolean v[][];
	static int n;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int min;
	static class Pair{
		int x;
		int y;
		
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		map = new int[n][n];
		map1 = new int[n][n];
		v = new boolean[n][n];
		min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] ==1 && v[i][j]==false) {
					bfs(j,i,cnt++);
				}
			}
		}
		
//		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(map1[i][j] +" ");			
//			}
//			System.out.println();
//		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(isEnd(j,i)) {
					System.out.println(j + " "+ i);
					v = new boolean[n][n];
					dfs(j,i,map1[i][j],0);
				}
			}
		}
		System.out.println(min);
		
	}
	static void bfs(int x, int y, int cnt) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			map1[temp.y][temp.x] = cnt;
			v[temp.y][temp.x]= true; 
			for(int i =0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				if(!isBound(nx, ny)) {
					continue;
				}
				if(map[ny][nx]==0) {
					continue;
				}
				if(v[ny][nx]){
					continue;
				}
				q.add(new Pair(nx,ny));				
			}			
		}
	}
	static void dfs(int x, int y,int mark, int cnt) {	
		if(map1[y][x]!=mark && map1[y][x] !=0) {
			if(min>cnt) {
				min =cnt;
			}
			return;
		}
		
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isBound(ny, nx)) {
				continue;
			}		
			if(v[ny][nx] ) {
				continue;
			}
			if(map1[ny][nx] == mark) {
				continue;
			}
			v[ny][nx] = true;
			dfs(nx,ny,mark,cnt+1);
			v[ny][nx] = false;
		}
	}
	static boolean isBound(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=n) {
			return false;			
		}
		return true;
	}
	static boolean isEnd(int x, int y) {		
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isBound(nx,ny)) {
				continue;
			}
			if(map[ny][nx]==0) {
				return true;
			}			
			
		}
		return false;
		
		
	}
}
