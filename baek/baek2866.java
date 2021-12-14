package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문자열 잘라내기
 * https://www.acmicpc.net/problem/2866
 */
public class baek2866 {
	static int R, C;
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		System.out.println(binarySearch());
	}

	static int binarySearch() {
		int res = C - 1;
		int l = 0, r = C - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(mid)) {
				r = mid - 1;
				res = Math.min(res, mid);
			} else {
				l = mid + 1;
			}
		}
		return res;
	}

	static boolean check(int start) {
		Set<String> set = new HashSet<>();

		for (int c = 0; c < C; c++) {
			StringBuilder str = new StringBuilder();
			for (int r = start + 1; r < R; r++) {
				str.append(map[r][c]);
			}
			if (set.contains(str.toString())) {
				return true;
			} else {
				set.add(str.toString());
			}
		}
		return false;
	}
}
