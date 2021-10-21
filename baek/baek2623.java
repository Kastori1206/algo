package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 음악프로그램
 * https://www.acmicpc.net/problem/2623
 */
public class baek2623 {
	static int[] indegree;
	static List<Integer>[] adj;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		indegree = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len - 1; j++) {
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				indegree[b]++;
				a = b;
			}
		}

		List<Integer> res = new ArrayList<>();
		StringBuilder answer = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);

			for (Integer next : adj[cur]) {
				indegree[next]--;

				if (indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		if (res.size() != N) {
			answer.append("0");
		} else {
			for (Integer v : res) {
				answer.append(v + "\n");
			}
		}

		System.out.println(answer.toString());

	}
}
