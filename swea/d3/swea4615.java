package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4615 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int test_case = 1 ; test_case<=1;test_case ++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //한변의 길이
			int M = Integer.parseInt(st.nextToken()); //돌을 놓는 횟수
			
			int black = 2;//흑돌 수
			int white = 2;//백돌 수
			
			int[][] map = new int[N+1][N+1]; //오셀로판
			
			//흑돌 1, 백돌 2
			for(int i =0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				
			}
		}	
	}
	void dfs(int[][] map, int x,int y,int d) {
		
	}
	boolean isBound(int x, int y, int N) {
		if(x<0 || x>=N || y<0 || y>=N) {
			return false;
		}
		return true;
	}
}
