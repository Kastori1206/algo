package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 주사위굴리기
 * https://www.acmicpc.net/problem/14499
 * 시뮬레이션
 */
public class baek14499 {
	static int N, M, x, y, K;
	static int[] dice = new int[7];	
	static int[][] map;
	// 동서북남
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		//지도 입력
		for(int r = 0 ;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		//명령어 받기
		st = new StringTokenizer(br.readLine());
		for(int i= 0;i<K;i++) {
			int d = Integer.parseInt(st.nextToken());
			int nr = dr[d-1] + y;
			int nc = dc[d-1] + x;
			
			if(!isIn(nr, nc)) {
				continue;
			}
			changeDice(d);
			if(map[nr][nc] == 0) {
				map[nr][nc] = dice[6];
			}else {
				dice[6] = map[nr][nc];
				map[nr][nc] = 0;
			}
			
			y = nr;
			x = nc;
			sb.append(dice[1] + "\n");
		}
		System.out.println(sb.toString());

		
	}
	public static void changeDice(int d) {
	    int[] temp = dice.clone();
	    // 6 밑면, 1 윗면
	    // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	    if (d == 1) {
	        dice[1] = temp[4];
	        dice[3] = temp[1];
	        dice[4] = temp[6];
	        dice[6] = temp[3];
	    } else if (d == 2) {
	        dice[1] = temp[3];
	        dice[3] = temp[6];
	        dice[4] = temp[1];
	        dice[6] = temp[4];
	    } else if (d == 3) {
	        dice[1] = temp[5];
	        dice[2] = temp[1];
	        dice[5] = temp[6];
	        dice[6] = temp[2];
	    } else {
	        dice[1] = temp[2];
	        dice[2] = temp[6];
	        dice[5] = temp[1];
	        dice[6] = temp[5];
	    }
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && c >=0 && r<N && c<M;
	}


}
