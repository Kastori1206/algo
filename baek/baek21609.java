package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 상어 중학교
 * https://www.acmicpc.net/problem/21609
 */
public class baek21609 {
	static class Block {
		int r, c, rainbow;
		List<Block> blocks = new ArrayList<>();

		public Block(int r, int c, int rainbow) {
			super();
			this.r = r;
			this.c = c;
			this.rainbow = rainbow;
		}

		@Override
		public String toString() {
			return "Block [r=" + r + ", c=" + c + ", rainbow=" + rainbow + "]";
		}
	}

	static int[][] map;
	static int N, M, answer;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			Block result = getMaxBlock();
			if (result.blocks.size() < 2) {
				break;
			}

			// 블록 삭제
			for (Block bb : result.blocks) {
				map[bb.r][bb.c] = -2;
			}
			// 점수
			answer += result.blocks.size() * result.blocks.size();

			// 중력
			gravity();

			// 90도 회전
			rotate();

			// 중력
			gravity();
		}
		System.out.println(answer);
	}

	public static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

	//중력
	public static void gravity() {
		for (int c = 0; c < N; c++) {
			int bottom = N - 1;
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] == -2) {
					continue;
				} else if (map[r][c] == -1) {
					bottom = r - 1;
				} else {
					int temp = map[r][c];
					map[r][c] = -2;
					map[bottom--][c] = temp;
				}
			}
		}
	}

	// 반시계 방향 회전
	public static void rotate() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				temp[N - j - 1][i] = map[i][j];
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				map[i][j] = temp[i][j];
			}
		}
	}

	public static Block getMaxBlock() {
		Block result = new Block(0, 0, -1);
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c]) {
					continue;
				}
				if (map[r][c] <= 0) {
					continue;
				}

				Block b = getBlock(new Block(r, c, 0));
				boolean flag = false;
				if (result.blocks.size() < b.blocks.size()) {
					result = b;
					flag = true;
				} else if (result.blocks.size() == b.blocks.size()) {
					if (result.rainbow < b.rainbow) {
						result = b;
						flag = true;
					} else if (result.rainbow == b.rainbow) {
						if (result.r < b.r) {
							result = b;
							flag = true;
						} else if (result.r == b.r) {
							if (result.c < b.c) {
								result = b;
								flag = true;
							}
						}
					}
				}
				if (flag) {
					visitCheck(result.blocks);
				}
			}
		}
		return result;
	}

	public static void visitCheck(List<Block> blocks) {
		for (Block b : blocks) {
			if (map[b.r][b.c] == 0) {
				continue;
			}
			visited[b.r][b.c] = true;
		}
	}

	public static Block getBlock(Block start) {
		Queue<Block> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		q.add(start);
		start.blocks.add(start);
		v[start.r][start.c] = true;
		int num = map[start.r][start.c];

		while (!q.isEmpty()) {
			Block b = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = b.r + dr[d];
				int nc = b.c + dc[d];

				if (!isIn(nr, nc)) {
					continue;
				}
				if (v[nr][nc]) {
					continue;
				}
				if (map[nr][nc] == num || map[nr][nc] == 0) {
					v[nr][nc] = true;

					if (map[nr][nc] == 0) {
						start.rainbow++;
					}
					start.blocks.add(new Block(nr, nc, 0));
					q.add(new Block(nr, nc, 0));
				}
			}

		}
		return start;
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
