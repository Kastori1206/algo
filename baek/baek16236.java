package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 아기상어
 * https://www.acmicpc.net/problem/16236
 */
public class baek16236 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	static int N, ans, w;
	// 상, 좌, 하, 우
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int[][] map, dist;
	static List<Point>[] fishs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];		//지도
		dist = new int[N][N];		//거리저장
		fishs = new ArrayList[8];	//무게에 따른 물고기 위치 저장(물고기 무게가 6이 가장 크기 때문에 크기가8)
		ans = 0;
		w = 2;						//현재 아기상어 무게
		int eat = 0;				//아기상어가 물고기 먹은 수
		
		//물고기 리스트 배열 초기화
		for (int i = 1; i <= 7; i++) {
			fishs[i] = new ArrayList<>();
		}
		
		Point start = null;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				//아기상어면
				if (map[r][c] == 9) {
					start = new Point(r, c);
				}
				//물고기면
				else if (map[r][c] != 0) {
					fishs[map[r][c]].add(new Point(r, c));
				}
			}
		}//입력끝
			
		
		while (true) {
			//먹을수 있는 물고기가 없으면
			if (!check(start)) {
				break;
			}
			//아기상어에서 움직일 수 있는 거리 구하기
			bfs(start);

			//아기상어 위치를 0으로 변경
			map[start.r][start.c] = 0;
			
			int min = Integer.MAX_VALUE;
			Point temp = null;
			int index = -1;		//물고기 배열의 리스트 인덱스 값
			int weight = -1;	//물고기 무게
			
			//먹을수 있는 물고기 중 거리가 조건에 맞는 물고기 찾기
			for (int i = 1; i < w; i++) {
				for (int j = 0; j < fishs[i].size(); j++) {
					temp = fishs[i].get(j);
					//거리가 짧으면
					if (min > dist[temp.r][temp.c] && dist[temp.r][temp.c] != -1) {
						min = dist[temp.r][temp.c];
						start = fishs[i].get(j);
						index = j;
						weight = i;
					//같은 거리 일 때
					} else if (min == dist[temp.r][temp.c] && dist[temp.r][temp.c] != -1) {
						//가장 위에 있는 물고기
						if (start.r > temp.r) {
							start = fishs[i].get(j);
							index = j;
							weight = i;
						//가장 위쪽이고 거리가 같은 물고기 일 때
						} else if (start.r == temp.r) {
							//왼쪽에 있는 물고기 선택
							if (start.c > temp.c) {
								start = fishs[i].get(j);
								index = j;
								weight = i;
							}
						}
					}
				}
			}
			
			//먹을 수 있는 물고기로 갈 수 없을 때 멈춤
			if (min == -1 || weight == -1 || index == -1) {
				break;
			}
			//아기상어 위치 변경
			map[start.r][start.c] = 9;
			
			//먹은 물고기 제거
			fishs[weight].remove(index);
			
			//물고기의 최대 크기가 6
			if (w < 7) {
				eat++;
				//물고기 무게와 먹은 수가 같으면 무게 증가
				if (eat == w) {
					w++;
					eat = 0;
				}
			}
			ans += min;
		}
		System.out.println(ans);
	}

	private static boolean check(Point start) {
		for (int i = 1; i < w; i++) {
			if (fishs[i].size() != 0) {
				return true;
			}
		}
		return false;
	}

	static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		dist = new int[N][N];
		//거리 배열을 -1로 초기화
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], -1);
		}

		q.add(start);
		//시작점 0
		dist[start.r][start.c] = 0;
		while (!q.isEmpty()) {
			Point p = q.poll();
			//사방 탐색
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				//배열 범위에 넘어가면
				if (!isIn(nr, nc)) {
					continue;
				}
				//방문 했으면
				if (dist[nr][nc] != -1) {
					continue;
				}
				//아기상어 무게보다 많으면
				if (map[nr][nc] > w) {
					continue;
				}
				dist[nr][nc] = dist[p.r][p.c] + 1;
				q.add(new Point(nr, nc));
			}
		}
	}

	static boolean isIn(int r, int c) {
		return r < N && c < N && r >= 0 && c >= 0;
	}
}
