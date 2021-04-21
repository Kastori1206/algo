package programmers;

import java.util.*;

public class 모두0으로만들기 {
	public static void main(String[] args) {
		int[] a = new int[] { -5, 0, 2, 1, 2 };
		int[][] edges = new int[][] { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };
		System.out.println(solution(a, edges));
	}

	static List<Integer>[] adj;
	static long answer;

	static class Node {
		int cur, p;

		public Node(int cur, int p) {
			super();
			this.cur = cur;
			this.p = p;
		}
	}

	public static long solution(int[] a, int[][] edges) {
		answer = 0;
		int n = a.length;
		long sum = 0;
		boolean flag = true;
		long[] temp = new long[n];
		for (int i = 0; i < n; i++) {
			if (a[i] != 0) {
				flag = false;
			}
			sum += (long) a[i];
			temp[i] = a[i];
		}

		if (sum != 0) {
			return -1;
		}
		adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			adj[u].add(v);
			adj[v].add(u);
		}
		Stack<Node> s = new Stack<>();
		boolean[] visited = new boolean[n];
		s.push(new Node(0, 0));
		while (!s.isEmpty()) {
			Node v = s.pop();

			if (visited[v.cur]) {
				answer += (long) Math.abs(temp[v.cur]);
				temp[v.p] += temp[v.cur];
				a[v.cur] = 0;
				continue;
			}
			visited[v.cur] = true;
			s.push(new Node(v.cur, v.p));
			for (int next : adj[v.cur]) {
				if (!visited[next]) {
					s.push(new Node(next, v.cur));
				}
			}
		}
		return answer;

	}
}
