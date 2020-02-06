package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek5549 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken()); //세로
		int M = Integer.parseInt(st.nextToken()); //가로
		
		char[][] map = new char[N+1][M+1];
		int K = Integer.parseInt(br.readLine());

		int[][] v;
		for(int i=1;i<=N;i++) {
			String temp = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = temp.charAt(j-1);
			}			
		}		
		
		for(int t = 0 ; t<K;t++) {
			result = new int[3]; //J, O, I
			v = new int[N+1][M+1];
			int[] arr = new int[4];
			String[] temp = br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			
			dfs(map,v,arr,arr[1],arr[0]);
			for(int i=0;i<3;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();			
		}		
	}
	static void dfs(char[][] map, int[][] v,int[] arr, int x,int y) {
		v[y][x] = 1;
		if(map[y][x] =='J') {
			result[0]++;
		}else if(map[y][x] =='O') {
			result[1]++;
		}else {
			result[2]++;
		}
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(!isBound(nx,ny,arr[1],arr[0],arr[3],arr[2])) {
				continue;
			}
			if(v[ny][nx] ==1) {
				continue;
			}			
			dfs(map,v,arr,nx,ny);
		}
	}
	static boolean isBound(int x, int y, int x1, int y1,int x2, int y2) {
		if(x < x1 || y<y1 || x>x2 || y>y2 ) {
			return false;
		}
		return true;
	}
}
