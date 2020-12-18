package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ACM Craft
 * https://www.acmicpc.net/problem/1005
 * 위상정렬
 */
public class baek1005 {

	static int T, N, K, W;
	static int[] D, inDegree;
	static List<Integer>[] adj;
	static Queue<Integer> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			D = new int[N + 1];

			adj = new List[N + 1];
			inDegree = new int[N + 1];
			q = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				adj[x].add(y);
				inDegree[y]++;
			}
			int[] result = new int[N + 1];

			W = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {
				result[i] = D[i];
				if (inDegree[i] == 0) {
					q.offer(i);
				}
			}

			// 건물의 총 소요시간 = 이전까지의 소요시간 + 현재 건물 소요시간
			while (!q.isEmpty()) {
				int now = q.poll();				
				
				for (int i = 0; i < adj[now].size(); i++) {
					int temp = adj[now].get(i);
					result[temp] = Math.max(result[temp], result[now] + D[temp]);
					inDegree[temp]--;
					
					if (inDegree[temp] == 0) {
						q.offer(temp);
					}
				}
			}

			System.out.println(result[W]);
		}
	}
}
