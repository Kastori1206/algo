package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek14267 {
	static int N, M;
	static List<Integer>[] adj;
	static int[] answer, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];

		answer = new int[N + 1];
		cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n != -1) {
				adj[n].add(i);
			}
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			cnt[i] += w;
		}

		for (int i = 2; i <= N; i++) {
			if (cnt[i] > 0) {
				dfs(i, cnt[i]);
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(answer[i] + " ");
		}
	}

	static void dfs(int n, int k) {
		answer[n] += k;
		for (Integer next : adj[n]) {
			dfs(next, k);
		}
	}
}
