package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사이클 게임 
 * https://www.acmicpc.net/problem/20040
 */
public class baek20040 {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
		int answer = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 싸이클 여부
			if (!union(x, y)) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	static int find(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if (xRoot == yRoot) {
			return false;
		}

		p[yRoot] = xRoot;
		return true;
	}
}
