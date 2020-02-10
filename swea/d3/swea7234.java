	package swea.d3;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class swea7234 {
		//상하좌우
		static int[] dx = {0, 0, -1, 1};
		static int[] dy = {-1, 1, 0, 0};
		public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			
			for(int t=1 ;t<=T ;t++) {
				int max = Integer.MIN_VALUE;
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int[][] map = new int[N+1][N+1];
				for(int i =0;i<B;i++) {
					st = new StringTokenizer(br.readLine());
					int y = Integer.parseInt(st.nextToken());
					int x = Integer.parseInt(st.nextToken());
					
					map[y][x] = -1;
					
					for(int j=0;j<4;j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						if(isBound(nx,ny,N) && map[ny][nx] != -1) {
							map[ny][nx] ++;
						}					
					}
					for(int j=0;j<4;j++) {
						int nx = x + (dx[j]*2);
						int ny = y + (dy[j]*2);
						if(isBound(nx,ny,N)&& map[ny][nx] != -1) {
							map[ny][nx] ++;
						}					
					}				
				}
				for(int i =1;i<=N;i++) {
					for(int j=1;j<=N;j++) {
						if(map[i][j] == -1) {
							continue;
						}
						if(map[i][j] > max) {
							max = map[i][j];
						}
					}
				}
				
				System.out.println(String.format("#%d %d", t,max));
			}
		}
		static boolean isBound(int x, int y,int N) {
			if(x>N || y>N || x<1|| y<1) {
				return false;
			}
			return true;
			
		}
	}
