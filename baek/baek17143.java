package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 낚시왕
 * https://www.acmicpc.net/problem/17143
 */
public class baek17143 {
	static class Shark implements Comparable<Shark> {
		int r, c, s, d, z;
		boolean isLive;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.isLive = true;
		}

		public void move(int r, int c) {
			// 범위를 초과하면 방향 변경
			if (!isIn(r, c)) {
				switch (this.d) {
				case 0:
					this.d = 1;
					this.r = 2;
					break;

				case 1:
					this.d = 0;
					this.r = R - 1;
					break;

				case 2:
					this.d = 3;
					this.c = C - 1;
					break;

				case 3:
					this.d = 2;
					this.c = 2;
					break;
				}
			} else {
				this.r = r;
				this.c = c;
			}
		}

		@Override
		public String toString() {
			return "Shark{" + "r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + '}';
		}

		@Override
		public int compareTo(Shark o) {
			return -Integer.compare(z, o.z);
		}
	}

	// 방향 상(0),하(1),우(2),좌(3)
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int R, C, M, answer;
	static Shark[] sharks;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R + 1][C + 1];
		sharks = new Shark[M + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());

			Shark shark = new Shark(r, c, s, d, z);
			sharks[i] = shark;
			map[r][c] = i;
		}

		for (int i = 1; i <= C; i++) {
			// 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
			answer += fishing(i);
			// 상어가 이동한다.
			move();
		}
		System.out.println(answer);
	}

	static int fishing(int c) {
		int idx = -1;
		for (int r = 1; r <= R; r++) {
			if (map[r][c] != 0 && sharks[map[r][c]].isLive) {
				idx = map[r][c];
				break;
			}
		}
		if (idx != -1) {
			sharks[idx].isLive = false;
			return sharks[idx].z;
		}
		return 0;
	}

	static void move() {
		map = new int[R + 1][C + 1];

		for (int j = 1; j < sharks.length; j++) {
			Shark shark = sharks[j];
			if (!shark.isLive) {
				continue;
			}
			int cnt = shark.s;

			if (shark.d == 0 || shark.d == 1) {
				cnt %= (R - 1) * 2;
			} else {
				cnt %= (C - 1) * 2;
			}

			while (cnt > 0) {
				int d = shark.d;
				int nr = shark.r + dr[d];
				int nc = shark.c + dc[d];
				shark.move(nr, nc);

				cnt--;
			}
			// map에 저장
			int r = shark.r;
			int c = shark.c;
			if (map[r][c] == 0) {
				map[r][c] = j;
			} else {
				if (sharks[map[r][c]].z < shark.z) {
					sharks[map[r][c]].isLive = false;
					map[r][c] = j;
				} else {
					shark.isLive = false;
				}
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r > 0 && c > 0 && r <= R && c <= C;
	}
}
