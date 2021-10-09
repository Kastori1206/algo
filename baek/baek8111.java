package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/**
 * 0과 1
 * https://www.acmicpc.net/problem/8111
 */
public class baek8111 {
	static final int MAX = 20000;
	static boolean[] visited;
	static Map<Integer, Character> map;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringBuilder answer = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			if (N == 1) {
				answer.append(1).append("/n");
				continue;
			}
			map = new HashMap<>();
			visited = new boolean[MAX];
			parent = new int[MAX];

			bfs(N);
			int idx = 0;
			while (idx != -1) {
				answer.append(map.get(idx));
				idx = parent[idx];
			}
			System.out.println(answer.reverse().toString());
		}

	}

	static void bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		parent[1] = -1;
		visited[1] = true;

		map.put(1, '1');
		while (!q.isEmpty()) {
			int cur = q.poll();

			int[] nexts = { (cur * 10) % N, (cur * 10 + 1) % N };
			for (int i = 0; i < 2; i++) {
				int next = nexts[i];
				if (visited[next]) {
					continue;
				}
				map.put(next, (char) (i + '0'));
				parent[next] = cur;
				if (next == 0) {
					return;
				}
				visited[next] = true;
				q.offer(next);
			}
		}
	}
}
