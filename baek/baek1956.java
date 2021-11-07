package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 운동
 * https://www.acmicpc.net/problem/1956
 */
public class baek1956 {
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int answer = Integer.MAX_VALUE;
		int[][] map = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[a - 1][b - 1] = c;
		}

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 0; i < V; i++) {
			if (map[i][i] < answer) {
				answer = map[i][i];
			}
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}
