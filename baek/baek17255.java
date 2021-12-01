package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * N으로 만들기
 * https://www.acmicpc.net/problem/17255
 */
public class baek17255 {
	static char[] N;
	static Set<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = st.nextToken().toCharArray();
		set = new HashSet<>();

		for (int i = 0; i < N.length; i++) {
			dfs(i, i, "" + N[i], "" + N[i]);
		}
		System.out.println(set.size());
	}

	static void dfs(int l, int r, String str, String res) {
		if (l == 0 && r == N.length - 1) {
			set.add(res);
			return;
		}
		if (l - 1 >= 0) {
			dfs(l - 1, r, N[l - 1] + str, res + "" + N[l - 1] + str);
		}
		if (r + 1 < N.length) {
			dfs(l, r + 1, str + N[r + 1], res + "" + str + N[r + 1]);
		}
	}
}
