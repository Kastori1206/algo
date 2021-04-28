package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 마법사 상어와 비바라기
 * https://www.acmicpc.net/problem/21610
 */
public class baek21610 {
	static class Cloud{
		int r, c;

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}		
	}
	static int[][] A;
	static int N;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Cloud> q = new LinkedList<>();
		//처음 구름의 위치
		q.add(new Cloud(N-1,0));
		q.add(new Cloud(N-1,1));
		q.add(new Cloud(N-2,0));
		q.add(new Cloud(N-2,1));
		
		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		print();
		for (int i = 0; i < M; i++) {
			System.out.println("=============="+i+"=============");

			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());

			
			boolean[][] visited = new boolean[N][N];
			int size = q.size();
			// 구름 이동
			for(int j=0;j<size;j++) {
				Cloud cloud = q.poll();
				
				int nr = (dr[d] * s + cloud.r) % N;
				int nc = (dc[d] * s + cloud.c) % N;
				if (nr < 0) {
					nr += N;
				}
				if (nc < 0) {
					nc += N;
				}
				A[nr][nc]++;
				visited[nr][nc] = true;
				q.add(new Cloud(nr,nc));				
			}
			print();
			// 물복사버그 바법
			for(int j=0;j<size;j++) {
				Cloud cloud = q.poll();
				
				//대각선 칸 찾기
				int cnt = 0;
				for(int k =1;k<4;k++) {
					int nr = dr[k*2+1]+cloud.r;
					int nc = dc[k*2+1]+cloud.c;
					
					if(!isIn(nr,nc)) {
						continue;
					}
					cnt++;
				}
				A[cloud.r][cloud.c] += cnt;
			}
			
			// 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진
			// 칸이 아니어야 한다.
			for(int r = 0;r<N;r++) {
				for(int c =0;c<N;c++) {
					if(visited[r][c]) {
						continue;
					}
					if(A[r][c] <2) {
						continue;
					}
					A[r][c]-=2;
					q.add(new Cloud(r,c));
				}
			}
			System.out.println("------------------------------");

			print();
		}
		//총 물의양
		int answer = 0;
		for(int r = 0;r<N;r++) {
			for(int c =0;c<N;c++) {
				answer += A[r][c];
			}
		}
		System.out.println(answer);
	}
	public static boolean isIn(int r,int c) {
		return r>=0 && c>=0 && r<N && c<N;
	}
	public static void print() {
		for(int r =0;r<N;r++) {
			for(int c =0;c<N;c++) {
				System.out.print(A[r][c] + " ");
			}
			System.out.println();
		}
	}
}
