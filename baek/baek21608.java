package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 상어초등학교
 * https://www.acmicpc.net/problem/21608
 */
public class baek21608 {
	static class Student {
		int r, c, blank, friend; // r,c ,빈공간 , 인접학생

		public Student(int r, int c, int blank, int friend) {
			super();
			this.r = r;
			this.c = c;
			this.blank = blank;
			this.friend = friend;
		}

		@Override
		public String toString() {
			return "Student [r=" + r + ", c=" + c + ", blank=" + blank + ", friend=" + friend + "]";
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map, frineds;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		frineds = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				frineds[index][j] = Integer.parseInt(st.nextToken());
			}
			Student s = check(index);
			map[s.r][s.c] = index;
		}

		int answer = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int index = map[r][c];
				int friend = 0;
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					for (int i = 0; i < 4; i++) {
						if (map[nr][nc] == frineds[index][i]) {
							friend++;
						}
					}
				}
				//만족도 구하기
				answer += (int) Math.pow(10, friend - 1);
			}
		}
		System.out.println(answer);

	}

	public static Student check(int index) {
		Student res = null;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0) {
					continue;
				}
				int blank = 0;
				int friend = 0;
				//인접한 빈칸구하기
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isIn(nr, nc)) {
						continue;
					}
					//좋아하는 학생수 구하기
					for(int i=0;i<4;i++) {
						if(frineds[index][i] == map[nr][nc]) {
							friend++;
						}
					}					
					if (map[nr][nc] != 0) {
						continue;
					}
					
					blank++;
				}
				
				/*
				 * 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
				 * 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
				 * 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.	
				 * 1,2,3 조건을 만족하는 위치 찾기
				 */
				if (res == null) {
					res = new Student(r, c, blank, friend);
				} else {
					//1번 조건
					if (res.friend < friend) {
						res = new Student(r, c, blank, friend);
					}
					//2,3 번 조건
					else if (res.friend == friend) {
						if (res.blank < blank) {
							res = new Student(r, c, blank, friend);
						}
					}
				}
			}
		}
		return res;
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

	public static void print() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
