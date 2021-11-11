package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 로고 
 * https://www.acmicpc.net/problem/3108
 */
public class baek3108 {
	static class Square {
		int x1, y1, x2, y2;

		protected Square(int x1, int y1, int x2, int y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static List<Square> squares;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		squares = new ArrayList<>();
		p = new int[N + 1];
		// 처음 위치 추가
		squares.add(new Square(0, 0, 0, 0));
		
		for(int i =0;i<=N;i++) {
			p[i] = i;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			squares.add(new Square(x1, y1, x2, y2));
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (check(i, j)) {
					union(i, j);
				}
			}
		}
		//안겹치는 부분 찾기
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i <= N; i++) {
			set.add(find(p[i]));
		}
		System.out.println(set.size() - 1);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b) {
			p[a] = b;
		} else if (a < b) {
			p[b] = a;
		}
	}

	static int find(int x) {
		if (p[x] == x) {
			return x;
		}
		return p[x] = find(p[x]);
	}

	//겹치는 부분 확인
	static boolean check(int i, int j) {
		Square a = squares.get(i);
		Square b = squares.get(j);

		if (a.y1 > b.y1 && a.x1 > b.x1 && a.y2 < b.y2 && a.x2 < b.x2) {
			return false;
		}
		if (a.y1 < b.y1 && a.x1 < b.x1 && a.y2 > b.y2 && a.x2 > b.x2 ) {
			return false;
		}
		if (a.y1 > b.y2 || a.x1 > b.x2 || a.y2 < b.y1 || a.x2 < b.x1) {
			return false;
		}
		return true;
	}
}
