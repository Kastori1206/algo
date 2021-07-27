package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 뮤탈리스크
 * https://www.acmicpc.net/problem/12869
 */
public class baek12869 {
	static int[][] permu = { {1,3,9},{1,9,3},{3,1,9},{3,9,1},{9,1,3},{9,3,1} };
	static class SCV{
		int a,b,c,x;

		public SCV(int a, int b, int c,int x) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
			this.x = x;
		}

		@Override
		public String toString() {
			return "SCV [a=" + a + ", b=" + b + ", c=" + c + ", x=" + x + "]";
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] scv = new int[3];
		
		int[][][] dp = new int[60+1][60+1][60+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<SCV> q= new LinkedList<>();
		q.add(new SCV(scv[0], scv[1], scv[2],0));
		int answer = 987654321;
		while(!q.isEmpty()) {
			SCV cur = q.poll();
			int a = cur.a;
			int b = cur.b;
			int c = cur.c;
			int cnt = cur.x;
//			System.out.println(cur);
			if(a == 0 && b ==0 && c == 0 ) {
				answer = Math.min(answer, cnt);
			}
			
			for(int i=0;i<6;i++) {
				int na = Math.max(a-permu[i][0], 0);
				int nb = Math.max(b-permu[i][1], 0);
				int nc = Math.max(c-permu[i][2], 0);
				
				if(dp[na][nb][nc] == 0) {
					dp[na][nb][nc] = dp[a][b][c] +1;
					q.offer(new SCV(na,nb,nc, dp[a][b][c] +1));
				}else if(dp[a][b][c] +1 > cnt+1) {
					dp[na][nb][nc] = cnt +1;
					q.offer(new SCV(na,nb,nc, cnt+1));
				}
			}
		}
		System.out.println(answer);
		
	}
}
