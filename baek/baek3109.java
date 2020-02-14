package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek3109 {
	//우상, 우, 우하
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};
	static int R;
	static int C;
	static int cnt;
	static int[][] a;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		a = new int[R][C];
		boolean[][] v =new boolean[R][C];
		for(int i =0;i<R;i++) {
			String temp = br.readLine();
			for(int j =0;j<C;j++) {
				map[i][j] = temp.charAt(j);
			}			
		}
		
		cnt = 0;
		for(int i =0;i<R;i++) {	
			flag =false;
			dfs(map,v,0,i);	
			if(flag) {
				cnt++;				
			}
		}

		System.out.println(cnt);
	}
	
	static void dfs(char[][] map,boolean[][] v, int x, int y) {
		if(x==C-1) {	
			flag =true;
			return;
		}
		
		for(int i = 0;i<3;i++) {
			if(flag) {
				return;
			}
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(!isBound(nx,ny)) {
				continue;
			}
			if(map[ny][nx] =='x') {
				continue;
			}
			if(v[ny][nx]) {
				continue;
			}
			v[ny][nx] =true;
			a[ny][nx] = cnt;						
			
			dfs(map,v,nx,ny);
			
		}
		
	
	}
	static boolean isBound(int x, int y){
		if(x<0 || x>=C || y<0|| y>=R) {
			return false;
		}
		return true;
	}
}
