package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 선발 명단
 * https://www.acmicpc.net/problem/3980
 */
public class baek3980 {
	static int answer;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			answer = 0;
			arr = new int[11][11];
			visited = new boolean[11];
			for (int r = 0; r < 11; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < 11; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int n, int res) {
		if (n == 11) {
			answer = Math.max(answer, res);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (arr[n][i] == 0) {
				continue;
			}
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			dfs(n + 1, res + arr[n][i]);
			visited[i] = false;
		}
	}
}
