package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 퍼즐
 * https://www.acmicpc.net/problem/1525
 */
public class baek1525 {
	static StringBuilder sb = new StringBuilder();
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static Queue<String> q = new LinkedList<String>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int r = 0; r < 3; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				sb.append(Integer.parseInt(st.nextToken()));
			}
		}

		if (sb.toString().equals("123456780")) {
			System.out.println(0);
		} else {
			map.put(sb.toString(), 0);
			q.offer(sb.toString());
			System.out.println(bfs(q, map));
		}

	}

	private static int bfs(Queue<String> q2, Map<String, Integer> map2) {
		while (!q.isEmpty()) {
			String str = q.poll();
			int zero = str.indexOf("0");
			int r = zero / 3;
			int c = zero % 3;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}

				int index = (3 * nr) + nc;

				sb = new StringBuilder(str);
				char ch = sb.charAt(index);
				sb.setCharAt(index, '0');
				sb.setCharAt(zero, ch);

				//정답
				if (sb.toString().equals("123456780")) {
					return map.get(str) + 1;
				}

				//새로 만들어진 형태
				if (!map.containsKey(sb.toString())) {
					q.offer(sb.toString());
					map.put(sb.toString(), map.get(str) + 1);
				}
			}
		}
		return -1;
	}

	private static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < 3 && c < 3;
	}
}
