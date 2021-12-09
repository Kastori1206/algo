package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * AC
 * https://www.acmicpc.net/problem/5430
 */
public class baek5430 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			String p = br.readLine();
			Deque<Integer> dq = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), "[ | , | ]");

			while (st.hasMoreTokens()) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			
			boolean reverse = false;
			boolean error = false;
			
			for (int i = 0; i < p.length(); i++) {
				char ch = p.charAt(i);
				if (ch == 'R') {
					reverse = reverse ? false : true;
				} else {
					if (dq.isEmpty()) {
						error = true;
						break;
					}
					if (reverse) {
						dq.pollLast();
					} else {
						dq.pollFirst();
					}
				}
			}
			
			if (error) {
				answer.append("error");
			} else {
				answer.append("[");
				if (reverse) {
					while (!dq.isEmpty()) {
						answer.append(dq.pollLast());
						if (dq.size() != 0) {
							answer.append(",");
						}
					}
				} else {
					while (!dq.isEmpty()) {
						answer.append(dq.pollFirst());
						if (dq.size() != 0) {
							answer.append(",");
						}
					}
				}
				answer.append("]");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString());
	}
}
