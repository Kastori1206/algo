package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class baek3055 {
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[R][C];
		Queue<Pair> q = new LinkedList<>();
		Pair start = null;
		Pair end = null;
		boolean[][] v = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j =0;j<C;j++) {
				arr[i][j]= temp.charAt(j);
				if(arr[i][j] == 'D') {
					end.x = j;
					end.y= i;
				}else if(arr[i][j] == 'S') {
					start.x = j;
					start.y = i;
				}else if(arr[i][j] == '*') {
					q.add(new Pair(j,i));
					v[i][j] = true;
				}else {
					v[i][j] = true;
				}
			}
		}//input
		
		
	
	}
	static void bfs(Queue<Pair> q, boolean[][] v, int x, int y,int R, int C) {
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			for(int i =0;i<4;i++) {
				int nx = temp.x +dx[i];
				int ny = temp.y +dy[i];
				
				if(!isBound(nx, ny, R, C)) {
					continue;
				}
				if(v[ny][nx]) {
					continue;
				}
				v[ny][nx] = true;
				
				
			}
		}
	}
	static boolean isBound(int x, int y, int R, int C) {
		if(x<0 || y<0|| x>=C|| y>=R) {			
			return false;
		}		
		return true;
	}
	
}
