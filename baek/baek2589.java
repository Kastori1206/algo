package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2589. 보물섬
 * https://www.acmicpc.net/problem/2589
 */

public class baek2589 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] v;
	static int[][] dist;
	static char[][] map;
	static Queue<Pair> q;
	static int ans;
	
	static class Pair{
		int x; 
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		
		ans = 0;
		
		for(int i =0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<n;i++) {
			for(int j =0 ;j<m;j++) {
				if(map[i][j] != 'L') {
					continue;
				}
				v =  new boolean[n][m];
				dist = new int[n][m];
				q = new LinkedList<>();				
				q.add(new Pair(j,i));				
				int temp =0;					
				
				while(!q.isEmpty()) {
					Pair p= q.poll();
					int x = p.x;
					int y = p.y;
					
					for(int k=0;k<4;k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						
						if(!isBound(nx, ny, n, m)) {
							continue;
						}
						if(v[ny][nx]) {
							continue;
						}
						if(map[ny][nx] !='L') {
							continue;
						}
						q.add(new Pair(nx,ny));
						dist[ny][nx] = dist[y][x]+1;
						v[ny][nx] = true;
						
						if(temp<dist[ny][nx]) {
							temp = dist[ny][nx];
						}
					}
				}
				if(ans <temp) {
					ans =temp;
				}
			}			
		}
		System.out.println(ans);
	}
	
	static boolean isBound(int x, int y, int n , int m) {
		if(x<0|| y<0||x>=m||y>=n) {
			return false;
		}
		return true;
	}
	
}
