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
		if (flag) {
			return 0;
		} else if (sum != 0) {
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
		dfs(0, -1, temp);

		return answer;
	}

	public static void dfs(int u, int p, long[] a) {
		for (int next : adj[u]) {
			if (next == p) {
				continue;
			}
			if (adj[next].size() != 1) {
				dfs(next, u, a);
			}

			answer += (long) Math.abs(a[next]);
			a[u] += a[next];
			a[next] = 0;
		}
	}
}
