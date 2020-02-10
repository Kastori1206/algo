package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea7236 {
	static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1 ; t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[][] map = new char[N][N];
			int [][] v = new int[N][N];
			int result = Integer.MIN_VALUE;
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = st.nextToken().charAt(0);
				}				
			}
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					int x = j; int y =i;
					if(map[y][x] =='W') {
						for(int k=0;k<8;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(!isBound(nx, ny, N)) {
								continue;
							}
							if(map[ny][nx] == 'W') {
								v[y][x] ++;
							}
						}					
					}
				}
			}					
			for(int i =0;i<N;i++) {
				for(int j =0;j<N;j++) {
					if(map[i][j] == 'W') {
						if(v[i][j] == 0) {
							v[i][j] =1;
						}
						if(result<v[i][j]) {
							result = v[i][j];
						}
					}
				}
			}			
			System.out.println(String.format("#%d %d", t,result));
		}			
	}
	static boolean isBound(int x, int y, int N) {
		if(x<0 || y<0|| x>=N || y>=N) {
			return false;
		}
		return true;
	}
}
