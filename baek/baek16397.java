package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 탈출
 * https://www.acmicpc.net/problem/16397
 */
public class baek16397 {
	static class Point {
		int n, cnt;

		public Point(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [n=" + n + ", cnt=" + cnt + "]";
		}
	}

	static int max, N, G, T, answer;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		answer = Integer.MAX_VALUE;

		visited = new boolean[100001];

		flag = false;
		bfs(new Point(N, 0));

		//결과 출력
		if (flag) {
			System.out.println(answer);
		} else {
			System.out.println("ANG");
		}
	}

	private static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.n] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int n = p.n;
			// 탈출 성공했을 때
			if (n == G) {
				// T보다 버튼 수 작은지 확인
				if (p.cnt <= T) {
					flag = true;
					answer = Math.min(answer, p.cnt);
				}
				return;
			}
			// A버튼 눌렀을 때
			if (n + 1 < 100000 && !visited[n + 1]) {
				visited[n + 1] = true;
				q.add(new Point(n + 1, p.cnt + 1));
			}

			// n*2가 99999를 넘 는지 확인
			n *= 2;
			if (n > 99999) {
				continue;
			}
			// n*2의 길이
			int len = (int) (Math.log10(n) + 1);
			// 가장 높은 자릿수 숫자 1 줄이기
			n -= (int) Math.pow(10, len - 1);

			// B버튼 눌렀을 때
			if (n > 0 && !visited[n]) {
				visited[n] = true;
				q.add(new Point(n, p.cnt + 1));
			}
		}
	}
}
