package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/* 아맞다우산
 * https://www.acmicpc.net/problem/17244
 */
public class baek17244 {
	static class Point{
		int r, c;

		public Point(int r, int c) {		
			this.r = r;
			this.c = c;
		}
		
	}
	static int R,C,answer;
	static char[][] map;
	static int[][] dist;	
	static boolean[] visited;
	static int[] nums;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Point start, end;
	static List<Point> list;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		answer = Integer.MAX_VALUE;
		map = new char[R][C];
//		dist = new int[R][C];
		
		list = new ArrayList<>();
		for(int r = 0 ; r<R ; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0;c<C;c++) {
				if(map[r][c] == 'S') {
					start = new Point(r,c);
				}else if(map[r][c] == 'E') {
					end = new Point(r,c);
				}else if(map[r][c] == 'X'){
					list.add(new Point(r,c));
				}				
			}
		}
		nums = new int[list.size()];		
		visited = new boolean[list.size()];
		permutation(0);

		System.out.println(answer);
		
	}
	private static void permutation(int index) {
		if(list.size() == index) {
			int result = 0;
			bfs(start);
			for(int i =0;i<nums.length;i++) {				
				Point p = list.get(nums[i]);
				result += dist[p.r][p.c];
				bfs(p);
			}
			result += dist[end.r][end.c];
			answer = Math.min(answer,result);			
			return;
		}
		
		for(int i =0;i<list.size(); i++) {
			if(visited[i]) {
				continue;
			}
			nums[index] = i;
			visited[i] = true;
			permutation(index+1);	
			visited[i] = false;
		}
	}
	
	private static void bfs(Point start) {
		dist = new int[R][C];

		Queue<Point> q = new LinkedList<>();
		q.add(start);
		dist[start.r][start.c] = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();		
			for(int d =0 ;d<4;d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(!isIn(nr, nc)) {
					continue;
				}
				
				if(map[nr][nc] == '#') {
					continue;
				}
				if(dist[nr][nc] != 0) {
					continue;
				}
				
				dist[nr][nc] = dist[p.r][p.c]+1;
				q.add(new Point(nr,nc));
			}
		}
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && c>=0 && r<R && c <C;
	}
}