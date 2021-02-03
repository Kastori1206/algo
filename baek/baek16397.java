package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 탈출
 * https://www.acmicpc.net/problem/16397
 */
public class baek16397 {
	static class Point{
		int n, cnt;

		public Point(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}		
	}
	static int max,N,G,T,answer;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		
		answer = Integer.MAX_VALUE;
		visited = new boolean[100001];
		
		bfs(new Point(N,1));
		
		
		if(answer<=T) {
			System.out.println(answer);
		}else {
			System.out.println("ANG");
		}
	}
	private static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.n] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int n = p.n;
			if(n==G) {
				answer= Math.min(answer, p.cnt);
				return;
			}
			if(n+1 <100000 && !visited[n+1]) {
				visited[n+1] = true;
				q.add(new Point(n+1, p.cnt+1));
			}			
			int len = (int)(Math.log10(n*2)+1);
			n = n*2 -(int)Math.pow(10, len-1);
			System.out.println("n: "+n);
			if(n!=0 && !visited[n]) {
				visited[n] = true;
				q.add(new Point(n,p.cnt+1));
			}
			
		}
		
	}
}
