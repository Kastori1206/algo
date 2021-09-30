package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리의 지름 
 * https://www.acmicpc.net/problem/1967
 */
public class baek1967 {
	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

	}

	static final int MAX = 10000;
	static int N, answer, maxV;
	static List<Edge>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = 0;
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));
		}
		dfs(1, 0);
		visited = new boolean[N + 1];
		dfs(maxV, 0);

		System.out.println(answer);

	}

	public static void dfs(int cur, int sum) {
		if (answer < sum) {
			answer = sum;
			maxV = cur;
		}

		visited[cur] = true;
		for (Edge next : adj[cur]) {
			if (visited[next.v]) {
				continue;
			}
			dfs(next.v, sum + next.w);
		}
	}

}
