package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 별자리 만들기
 * https://www.acmicpc.net/problem/4386
 */
public class baek4386 {
	static class Node {
		int v;
		double x, y;

		public Node(int v, double x, double y) {
			super();
			this.v = v;
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double dist;

		public Edge(int from, int to, double dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(dist, o.dist);
		}

	}

	static int find(int[] p, int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p, p[x]);
	}

	static void union(int[] p, int x, int y) {
		int xRoot = find(p, x);
		int yRoot = find(p, y);
		if (x < y) {
			p[yRoot] = xRoot;
		} else {
			p[xRoot] = yRoot;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Node> nodes = new ArrayList<>();
		int[] p = new int[N];

		for (int i = 0; i < N; i++) {
			p[i] = i;
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			nodes.add(new Node(i, x, y));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < N - 1; i++) {
			Node from = nodes.get(i);
			for (int j = i + 1; j < N; j++) {
				Node to = nodes.get(j);
				pq.offer(new Edge(i, j, Math.sqrt(Math.pow(from.x - to.x, 2) + Math.pow(from.y - to.y, 2))));
			}
		}

		double answer = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (find(p, cur.from) != find(p, cur.to)) {
				union(p, cur.from, cur.to);
				answer += cur.dist;
			}
		}
		System.out.println(Math.round(answer * 100) / 100.0);
	}
}
