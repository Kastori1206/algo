package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 해킹
 * https://www.acmicpc.net/problem/10282
 */
public class baek10282 {
	static class Edge implements Comparable<Edge> {
		int v;
		int s;

		public Edge(int v, int s) {
			super();
			this.v = v;
			this.s = s;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(s, o.s);
		}

	}

	static List<Edge>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				adj[b].add(new Edge(a, s));
			}

			
			//다익스트라
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[c] = 0;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();

			pq.offer(new Edge(c, 0));
			while (!pq.isEmpty()) {
				Edge cur = pq.poll();

				int v = cur.v;
				int s = cur.s;
				if (dist[v] < s) {
					continue;
				}
				for (Edge next : adj[v]) {
					if (dist[next.v] <= next.s + s) {
						continue;
					}
					dist[next.v] = next.s + s;
					pq.offer(new Edge(next.v, next.s + s));
				}
			}

			//시간과 몇대의컴퓨터 감염인지 검사
			int cnt = 0;
			int time = 0;
			for (int i = 1; i <= n; i++) {
				if (dist[i] == Integer.MAX_VALUE) {
					continue;
				}
				cnt++;
				time = Math.max(time, dist[i]);
			}
			answer.append(cnt + " " + time + "\n");
		}
		System.out.println(answer.toString());
	}

}
