package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리 
 * https://www.acmicpc.net/problem/1068
 */
public class baek1068 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}

		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) {
				root = i;
			} else {
				adj[p].add(i);
			}
		}

		int delete = Integer.parseInt(br.readLine());

		if (delete == root) {
			System.out.println(0);
			return;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(root);

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (adj[cur].size() == 0) {
				answer++;
			}
			boolean flag = false;
			for (Integer next : adj[cur]) {
				if (next == delete) {
					flag = true;
					continue;
				}
				q.offer(next);
			}

			//노드를 지웠을 때 현재 노드가 리프노드인지 확인
			if(flag) {
				adj[cur].remove((Integer)delete);	
				answer = adj[cur].size() == 0 ? answer+1 : answer;
			}
		}

		System.out.println(answer);
	}

}
