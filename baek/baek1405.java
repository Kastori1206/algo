package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미친로봇
 * https://www.acmicpc.net/problem/1405
 */
public class baek1405 {
	static int N;
	static double[] P;
	// 동서남북
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static double answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		P = new double[4];
		for (int i = 0; i < 4; i++) {
			P[i] = Double.parseDouble(st.nextToken()) * 0.01;
		}

		visited = new boolean[30][30];
		visited[15][15] = true;
		dfs(15, 15, 0, 1.0);

		System.out.println(answer);
	}

	private static void dfs(int r, int c, int depth, double p) {
		if (N == depth) {
			answer += p;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			//방문 했거나 확률이 0인경우
			if (visited[nr][nc] || P[d] == 0) {
				continue;
			}
			visited[nr][nc] = true;
			dfs(nr, nc, depth + 1, p * P[d]);
			visited[nr][nc] = false;
		}
	}
}
