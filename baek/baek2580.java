package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 스도쿠
 * https://www.acmicpc.net/problem/2580
 */
public class baek2580 {
	static class Point {
		int r, c;
		List<Integer> list;

		public Point(int r, int c, List<Integer> list) {
			this.r = r;
			this.c = c;
			this.list = list;
		}

	}

	static int[][] map;
	static List<Point> blanks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size = 9;

		map = new int[size][size];
		blanks = new ArrayList<>();

		for (int r = 0; r < size; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < size; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (map[r][c] == 0) {
					List<Integer> list = possible(r, c);
					if(list.size() == 1) {
						map[r][c] = list.get(0);
					}else {
						blanks.add(new Point(r, c, list));					
					}
				}
			}
		}
		search(blanks, 0);
	}

	private static List<Integer> possible(int r, int c) {
		boolean[] visited = new boolean[10];

		for (int i = 0; i < 9; i++) {
			// 세로검사
			if (map[i][c] != 0) {
				visited[map[i][c]] = true;
			}
			// 가로검사
			if (map[r][i] != 0) {
				visited[map[r][i]] = true;
			}
		}

		// 구역검사
		int nr = (r / 3)*3;
		int nc = (c / 3)*3;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				visited[map[i][j]] = true;
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			if (visited[i]) {
				continue;
			}
			list.add(i);
		}
		return list;
	}

	private static boolean check(int r, int c, int value) {
		for (int i = 0; i < 9; i++) {
			// 세로검사
			if (i!=r && map[i][c] == value) {
				return false;
			}
			// 가로검사
			if (i!=c && map[r][i] == value) {
				return false;
			}
		}


		// 구역검사
		int nr = (r / 3) *3;
		int nc = (c / 3) *3;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if(i==r && j ==c) {
					continue;
				}
				if(map[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	private static void search(List<Point> list, int index) {
		if(index == list.size()) {
			for(int r = 0; r<9;r++) {
				for(int c = 0;c<9;c++) {
					System.out.print(map[r][c] +" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		Point p = list.get(index);
		int r = p.r;
		int c  = p.c;
		for(int i = 0;i<p.list.size();i++) {
			map[r][c] = p.list.get(i);
			if(check(r,c,p.list.get(i))) {
				search(list, index+1);
			}
			map[r][c] = 0;
		}
	}
}
