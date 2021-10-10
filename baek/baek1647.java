package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도시 분할 계획
 * https://www.acmicpc.net/problem/1647
 */
public class baek1647 {
	static class Edge implements Comparable<Edge> {
		int from, to, d;

		public Edge(int from, int to, int d) {
			super();
			this.from = from;
			this.to = to;
			this.d = d;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.d, o.d);
		}
	}

	static int find(int[] p, int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p, p[x]);
	}

	static void union(int[] p, int x, int y) {
		if (x < y) {
			p[find(p, y)] = find(p, x);
		} else {
			p[find(p, x)] = find(p, y);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		int maxDist = 0;
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			pq.add(new Edge(a, b, d));
		}

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (find(p, cur.from) != find(p, cur.to)) {
				answer += cur.d;
				union(p, cur.from, cur.to);
				maxDist = cur.d;
			}
		}

		bw.write(String.valueOf(answer - maxDist));
		bw.flush();
		bw.close();
	}
}
