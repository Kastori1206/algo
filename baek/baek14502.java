package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 연구소
 * https://www.acmicpc.net/problem/14502
 */
public class baek14502 {
	static class Point{
		int r,c;

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
	
	static int N, M, ans, init;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> virus;
	static List<Point> blanks;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		virus = new LinkedList<>();
		blanks = new ArrayList<>();
		
		ans = Integer.MIN_VALUE;
		
		init = 0;
		for(int r =0; r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c =0;c<M;c++) {
				int temp = Integer.parseInt(st.nextToken());
				map[r][c] = temp;
				if(temp == 2) {
					virus.add(new Point(r,c));
				}else if(temp == 0) {
					blanks.add(new Point(r,c));
					init++;
				}
			}
		}
		combi(0,0,blanks.size(),3,new Point[3]);
		System.out.println(ans);
	}
	private static void combi(int index, int cur, int n, int r,Point[] result) {
		// TODO Auto-generated method stub
		if(r==index) {
			bfs(result);
			return;
		}
		for(int i =cur ; i<n;i++) {
			result[index] = blanks.get(i);
			combi(index+1,i,n,r,result);
		}
		
	}
	private static void bfs(Point[] result) {
		Queue<Point> q = new LinkedList<>();
		q.addAll(virus);
		visited = new boolean[N][M];
		for(int i =0;i<3;i++) {
			visited[result[i].r][result[i].c] = true;
		}
		
		int n = init-3;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int d =0 ;d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				if(visited[nr][nc]) {
					continue;
				}
				if(map[nr][nc]!=0) {
					continue;
				}
				visited[nr][nc] = true;
				q.add(new Point(nr,nc));
				n--;
			}			
		}
		ans = Math.max(ans, n);
	}
	
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<N && c<M;
	}
}
