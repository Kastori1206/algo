package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 문제 추천 시스템 Version 1 
 * https://www.acmicpc.net/problem/21939
 */
public class baek21939 {
	static class Problem implements Comparable<Problem> {
		int p, l;

		protected Problem(int p, int l) {
			super();
			this.p = p;
			this.l = l;
		}

		@Override
		public int compareTo(Problem o) {
			if (l == o.l) {
				return Integer.compare(p, o.p);
			}
			return Integer.compare(l, o.l);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> problems = new HashMap<Integer, Integer>();
		TreeSet<Problem> tree = new TreeSet<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			tree.add(new Problem(p, l));
			problems.put(p, l);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					answer.append(tree.last().p).append("\n");
				} else {
					answer.append(tree.first().p).append("\n");
				}
			} else if (command.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				tree.add(new Problem(p, l));
				problems.put(p, l);

			} else {
				int p = Integer.parseInt(st.nextToken());
				tree.remove(new Problem(p, problems.get(p)));
				problems.remove(p);
			}
		}
		System.out.println(answer.toString());
	}
}
