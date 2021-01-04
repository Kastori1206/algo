package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 욕심쟁이 판다.
 * https://www.acmicpc.net/problem/1937
 */
public class baek1937 {
	static class DaeNamu implements Comparable<DaeNamu>{
		int r, c, weight;

		public DaeNamu(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(DaeNamu o) {			
			return -Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "DaeNamu [r=" + r + ", c=" + c + ", weight=" + weight + "]";
		}		
		
	}
	static int N, answer;
	static int[][] map,dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		PriorityQueue<DaeNamu> pq = new PriorityQueue<>();
		
		for(int r = 0 ; r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ;c < N ;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				pq.offer(new DaeNamu(r, c, map[r][c]));
			}
		}
	
		answer = 0;
		
		while(!pq.isEmpty()) {
			DaeNamu daenamu = pq.poll();
			dp[daenamu.r][daenamu.c]++;
			answer = Math.max(dp[daenamu.r][daenamu.c], answer);
			for(int d =0 ;d<4;d++) {
				int nr = daenamu.r + dr[d];
				int nc = daenamu.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(map[nr][nc] >= map[daenamu.r][daenamu.c]) {
					continue;
				}
				dp[nr][nc] = Math.max(dp[nr][nc], dp[daenamu.r][daenamu.c]);
			}
		}
		System.out.println(answer);
	}

		
	private static boolean isIn(int r,int c ) {
		return r>=0 && c>=0 &&r<N && c<N;
	}
}
