package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}
		}));
	}
	static int R,C;
	public static int  numIslands(char[][] grid) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int answer = 0;
		R = grid.length;
		C = grid[0].length;
		
		boolean[][] visited = new boolean[R][C];
		for(int r =0;r<R;r++) {
			for(int c = 0;c<C;c++) {
				if(visited[r][c]) {
					continue;
				}
				if(grid[r][c] != '1') {
					continue;
				}
				Queue<int[]> q = new LinkedList<>();
				q.add(new int[] {r,c});
				visited[r][c] = true;
				while(!q.isEmpty()) {
					int[] temp = q.poll();
					for(int d = 0 ;d<4;d++) {
						int nr = temp[0] + dr[d];
						int nc = temp[1] + dc[d];
						
						if(!isIn(nr, nc)) {
							continue;
						}
						if(visited[nr][nc]) {
							continue;
						}
						if(grid[nr][nc] != '1') {
							continue;
						}
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
				answer++;
			}
		}
		return answer;
	}
	public static boolean isIn(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
}
