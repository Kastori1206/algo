package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 7699. 수지의 수지 맞는 여행
 */
public class swea7699 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int result = 0;
	static int R;
	static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t<=T ; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] check = new int[26];
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[R][C];
			for(int i =0;i<R;i++) {
				map[i] = br.readLine().toCharArray();
			}
			int cur = map[0][0] - 'A';
			check[cur] = 1;
			go(map, check, 0, 0, 1);

			System.out.println("#" + t + " " + result);

		}
	}
	private static void go(char[][] map, int[] check, int x, int y, int max) {
        if (max > result) {
        	result = max;        	
        }
        if(result == 26) {
        	return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isBound(nx, ny)) {
            	continue;
            }
            int temp = map[ny][nx] - 'A';
            if(check[temp]!=0) {
            	continue;
            }
            check[temp] = 1;
            go(map, check, nx, ny, max + 1);
            check[temp] = 0;
        }		
	}
	static boolean isBound(int x, int y) {
		if(x<0 || y<0 || x>=C || y>=R){
			return false;
		}
		return true;
	}
}


