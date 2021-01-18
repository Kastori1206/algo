package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 물통
 * https://www.acmicpc.net/problem/2251
 */
public class baek2251 {
	static class Water{
		int a,b,c;

		public Water(int a, int b, int c) {
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
	static List<Integer> answer = new ArrayList<>();
	static int A,B,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int N =Math.max(Math.max(A, B),C);
		
		visited = new boolean[3][N];
		
		bfs(new Water(0,0,C));
	}
	private static void bfs(Water water) {
		Queue<Water> q = new LinkedList<>();
		visited[3][water.c] = true;
		
		while(!q.isEmpty()) {
			Water w = q.poll();
			
			if(w.a == 0) {
				answer.add(w.c);
			}
			for(int d =0;d<3;d++) {				
				//A의 물통 옮김
				int temp;
				if(d == 0) {
					if(visited[d][w.a]) {
						continue;
					}
					visited[d][w.a] = true;
					//B로 옮김
					temp = B - w.b + w.a; 
					if(temp >B) {						
						q.offer(new Water(w.a-(temp-B),temp -B,w.c));
					}else {
						q.offer(new Water(0, temp, w.c));
					}
					//C로 옮김
					temp = B - w.b + w.a;
					if(temp >B) {						
						q.offer(new Water(w.a-(temp-B),temp -B,w.c));
					}else {
						q.offer(new Water(0, temp, w.c));
					}
				}
				//B의 물통 옮김
				if(d == 1) {
					int temp = B - w.b + w.a; 
					visited[d][w.a] = true;
					//A로 옮김
					if(temp >B) {						
						q.offer(new Water(w.a-(temp-B),temp -B,w.c));
					}
					//C로 옮김
					else {
						q.offer(new Water(0, temp, w.c));
					}
				}
				//C의 물통 옮김
				if(d == 2) {
					int temp = B - w.b + w.a; 
					visited[d][w.a] = true;
					//A로 옮김
					if(temp >B) {						
						q.offer(new Water(w.a-(temp-B),temp -B,w.c));
					}
					//B로 옮김
					else {
						q.offer(new Water(0, temp, w.c));
					}
				}
			}
		}
		
	}

}
