package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질 2
 * https://www.acmicpc.net/problem/12851
 */
public class baek12851 {
	static class Point {
		int x, d;

		public Point(int x, int d) {
			super();
			this.x = x;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", d=" + d + "]";
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dist = new int[100001];
		boolean[] check = new boolean[100001];
		int size = dist.length;
		
		check[N] = true;
		dist[N] = 0;
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(N,0));
		int cnt = 0;
		while (!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == K) {
				if(dist[now.x]==now.d) {
					cnt++;
				}
			}			
			if (now.x - 1 >= 0) {
				if (!check[now.x - 1]) {
					q.add(new Point(now.x - 1,dist[now.x]+1));
					dist[now.x - 1] = dist[now.x] + 1;
					check[now.x -1] = true;
				}else if(dist[now.x-1] == now.d+1) {
					q.add(new Point(now.x -1, now.d+1));
				}
			
			}
			if (now.x + 1 < size ) {
				if (!check[now.x + 1]) {
					q.add(new Point(now.x + 1,dist[now.x]+1));
					dist[now.x + 1] = dist[now.x] + 1;
					check[now.x +1] = true;
				}else if(dist[now.x+1] == now.d+1) {
					q.add(new Point(now.x+1, now.d+1));
				}
				
			}
			if (now.x * 2 < size) {
				if (!check[now.x*2]) {					
					q.add(new Point(now.x * 2,now.d +1));
					dist[now.x * 2] = now.d +1;
					check[now.x *2] = true;
					
				}else if(dist[now.x*2] == now.d+1) {
					q.add(new Point(now.x*2, now.d+1));
				}
			}
			
		}
		System.out.println(dist[K]);
		System.out.println(cnt ==0 ? 1:cnt);
	}
}