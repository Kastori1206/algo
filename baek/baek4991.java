package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 로봇 청소기
 * acmicpc.net/problem/4991
 */
public class baek4991 {

	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static char[][] map;
	static boolean[][] visited;
	static int R, C, answer;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<Point> dusts;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		dusts = new ArrayList<>();
		Point robot = null;
		for(int r =0;r<R;r++) {
			String temp = br.readLine();
			for(int c =0;c<C;c++) {
				char ch = temp.charAt(c);
				if(ch=='o') {
					robot = new Point(r,c);
				}else if(ch=='*') {
					dusts.add(new Point(r,c));
				}				
				map[r][c] = ch;				
			}
		}
		
		
	}
	private static void bfs(Point start) {
		visited = new boolean[R][C];
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			
		}
	}
	private static void permutation(int[] arr, int index, int n, boolean[] v) {
		if(index == n) {
			return;
		}
		for(int i=0;i<n;i++) {
			if(v[i]) {
				continue;
			}
			v[i] = true;
			arr[index] = i;
			permutation(arr, index+1, n, v);
			v[i] = false;
		}
	}
}
