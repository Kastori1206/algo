package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 교점에 별 만들기 
 * https://programmers.co.kr/learn/courses/30/lessons/87377
 */
public class 교점에별만들기 {
	public static void main(String[] args) {
		int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
		String[] answer = solution(line);
		for (String str : answer) {
			System.out.println(str);
		}

	}

	public static String[] solution(int[][] line) {
		List<long[]> list = new ArrayList<>();
		long minX = Long.MAX_VALUE;
		long minY = Long.MAX_VALUE;
		long maxX = Long.MIN_VALUE;
		long maxY = Long.MIN_VALUE;
		for (int i = 0; i < line.length; i++) {
			long a = line[i][0];
			long b = line[i][1];
			long e = line[i][2];
			for (int j = i + 1; j < line.length; j++) {
				long c = line[j][0];
				long d = line[j][1];
				long f = line[j][2];
				long temp = a * d - b * c;
				if (temp == 0) {
					continue;
				}
				long x = b * f - e * d;
				long y = e * c - a * f;

				// AD - BC = 0인 경우 두 직선은 평행 또는 일치
				if (x % temp != 0 || y % temp != 0) {
					continue;
				}

				x /= temp;
				y /= temp;

				minX = Math.min(minX, x);
				maxX = Math.max(maxX, x);
				minY = Math.min(minY, y);
				maxY = Math.max(maxY, y);

				list.add(new long[] { x, y });
			}
		}
		int R = (int) (maxY - minY + 1);
		int C = (int) (maxX - minX + 1);
		char[][] res = new char[R][C];

		for (long[] l : list) {
			int r = (int) (maxY - l[1]);
			int c = (int) (l[0] - minX);
			res[r][c] = '*';
		}

		String[] answer = new String[R];

		for (int r = 0; r < R; r++) {
			StringBuilder sb = new StringBuilder();
			for (int c = 0; c < C; c++) {
				if (res[r][c] == '*') {
					sb.append("*");
				} else {
					sb.append(".");
				}
			}
			answer[r] = sb.toString();

		}

		return answer;
	}

}
