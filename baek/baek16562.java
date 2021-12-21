package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 친구비
 * https://www.acmicpc.net/problem/16562
 */
public class baek16562 {
	static int[] p, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		p = new int[N + 1];
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = i;
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);
		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer += arr[i];
		}
		if (answer > k) {
			System.out.println("Oh no");
		} else {
			System.out.println(answer);
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			p[b] = a;
			arr[a] = Math.min(arr[a], arr[b]);
			arr[b] = 0;
		}
	}

	static int find(int x) {
		if (x == p[x]) {
			return x;
		}
		return p[x] = find(p[x]);
	}
}
