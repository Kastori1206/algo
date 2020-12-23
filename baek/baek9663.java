package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * N - Queen
 * https://www.acmicpc.net/problem/9663
 */
public class baek9663 {
	static int N, ans;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		ans = 0;
		
		for(int i =0 ; i<N;i++) {
			go(0,i);
			
		}
		
		System.out.println(ans);
	}

	private static void go(int r, int c) {
		System.out.println(r + " " + c);
		if (r == N - 1) {
			ans++;
			return;
		}
		visited[r][c] = true;
		for(int i =0;i<N;i++) {
			if(check(r+1, i)) {
				go(r+1,i);
			}
		}
		visited[r][c] = false;
	}

	private static boolean check(int nr, int nc) {
		int c = 1;
		for (int r = nr - 1; r >= 0; r--) {
			if (nc - c >= 0 && visited[r][nc - c]) {
				return false;
			}
			if (visited[r][nc]) {
				return false;
			}
			if (nc + c < N && visited[r][nc + c]) {
				return false;
			}
			c++;
		}
		return true;
	}
}
