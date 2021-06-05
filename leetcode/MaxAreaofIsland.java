package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaofIsland {
	public static void main(String[] args) {
		int[][] grid = new int[][] {
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};
		System.out.println(maxAreaOfIsland(grid));
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R, C;
    public static int maxAreaOfIsland(int[][] grid) {
    	int answer = 0;
    	R = grid.length;
    	C = grid[0].length;
    	
    	Queue<int[]> q = new LinkedList<>();
    	boolean[][] visited = new boolean[R][C];
    	for(int r =0; r<R; r++) {
    		for(int c =0 ;c<C;c++) {
    			if(visited[r][c]) {
    				continue;
    			}
    			if(grid[r][c] != 1) {
    				continue;
    			}
    			int res = 1;
    			q.add(new int[] {r,c});
    			visited[r][c] = true;
    			while(!q.isEmpty()) {
    				int[] temp = q.poll();
    				for(int d =0 ;d<4;d++) {
    					int nr = temp[0] + dr[d];
    					int nc = temp[1] + dc[d];
    					
    					if(!isIn(nr, nc)) {
    						continue;
    					}
    					if(visited[nr][nc]) {
    						continue;
    					}
    					if(grid[nr][nc] != 1) {
    						continue;
    					}
    					res++;
    					visited[nr][nc] = true;
    					q.add(new int[] {nr,nc});
    				}
    			}
    			answer = Math.max(answer, res);
    		}
    	}
    	return answer;
    }
    public static boolean isIn(int r, int c) {
    	return r>=0 && r<R&&  c>=0 && c<C;
    }

}
