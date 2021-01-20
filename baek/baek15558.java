package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 점프게임
 * https://www.acmicpc.net/problem/15558
 */
public class baek15558 {
	static class Node {
		int r, c, s; // r = 지도 번호 0 ,1 / c = 칸의 위치 / s = 경과시간

		public Node(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", s=" + s + "]";
		}

	}

	static boolean[][] visited;
	static int N, K, answer, MAX = 200001;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[2][MAX];
		answer = 0;

		for (int i = 0; i < 2; i++) {
			String temp = br.readLine();
			for (int j = 1; j <= N; j++) {
				if (temp.charAt(j - 1) == '0') {
					visited[i][j] = true;
				}
			}
		}

		bfs(new Node(0, 1, 1));

		System.out.println(answer);
	}

	private static void bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int r = node.r;
			int c = node.c;
			int s = node.s;
			if (c >= N) {
				answer = 1;
				return;
			}

			// 한칸 앞으로
			if (c + 1 <= MAX && !visited[r][c + 1] && c + 1 > s) {
				visited[r][c + 1] = true;
				q.add(new Node(r, c + 1, s + 1));
			}

			// 한칸 뒤로
			if (c - 1 > 0 && !visited[r][c - 1] && c - 1 > s) {
				visited[r][c - 1] = true;
				q.add(new Node(r, c - 1, s + 1));
			}

			// 반대로 점프
			r = r == 0 ? 1 : 0;
			if (c + K <= MAX && !visited[r][c + K] && c + K > s) {
				visited[r][c + K] = true;
				q.add(new Node(r, c + K, s + 1));
			}
		}
	}
}
