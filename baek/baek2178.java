package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 2178. 미로탐색
 * https://www.acmicpc.net/problem/2178
 */
public class baek2178 {
	static int n;
	static int m;
	static int min;
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y =y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		int[][] map = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		boolean[][] v = new boolean[n+1][m+1];
		
		for(int i =1;i<=n;i++) {
			String temp = br.readLine();
			for(int j=1;j<=m;j++) {
				map[i][j] = temp.charAt(j-1) -'0';
				if(map[i][j]==0) {
					v[i][j] = true;
				}
			}
		}
		
		bfs(map,v);
		System.out.println(dist[n][m]);

	}
	static void dfs(int[][] map, boolean[][] v,int x, int y, int cnt) {
		if(x== m && y==n) {
			if(min >cnt) {
				min =cnt;
			}
			return;
		}
		
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(!isBound(nx, ny)) {
				continue;
			}
			if(v[ny][nx]) {
				continue;
			}			
			v[ny][nx] =true;
			dfs(map,v,nx,ny,cnt+1);
			v[ny][nx]= false;
			
		}
	}
	static void bfs(int[][] map, boolean[][] v) {
		Queue<Pair> q = new LinkedList<>();
		int x =1; int y =1;
		dist[y][x] = 1;
		q.add(new Pair(x, y));
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			for(int i =0;i<4;i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(!isBound(nx, ny)) {
					continue;
				}
				if(v[ny][nx]) {
					continue;
				}			
				if (dist[ny][nx] !=0 ) {
					continue;
				}
				dist[ny][nx] = dist[temp.y][temp.x] +1;
				q.add(new Pair(nx,ny));						
				
			}
		}		
	}
	static boolean isBound(int x,int y) {
		if(x<1||y<1||y>n||x>m) {
			return false;
		}
		return true;
	}
}
