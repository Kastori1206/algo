package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 중량제한
 * https://www.acmicpc.net/problem/1939
 */
public class baek1939 {
	static class Edge {
		int v, w;

		protected Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
	}

	static int N, M, start, end;
	static List<Edge>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		int max = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[a].add(new Edge(b, w));
			adj[b].add(new Edge(a, w));

			max = Math.max(max, w);
		}
		st = new StringTokenizer(br.readLine());

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int l = 0, r = max;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (bfs(mid)) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		System.out.println(r);
	}

	static boolean bfs(int limit) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == end) {
				return true;
			}

			for (Edge next : adj[cur]) {
				int v = next.v;
				int w = next.w;

				if (visited[v]) {
					continue;
				}
				if (limit > w) {
					continue;
				}
				visited[v] = true;
				q.offer(v);
			}
		}
		return false;
	}
}
