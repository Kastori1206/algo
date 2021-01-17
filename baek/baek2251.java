package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 물통
 * https://www.acmicpc.net/problem/2251
 */
public class baek2251 {
	static class water{
		int a,b,c;

		public water(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "water [a=" + a + ", b=" + b + ", c=" + c + "]";
		}
		
	}
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int N =Math.max(Math.max(A, B),C);
		
		visited = new boolean[3][N];
	}
}
