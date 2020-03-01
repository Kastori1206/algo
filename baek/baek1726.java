package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 로봇
 * https://www.acmicpc.net/problem/1726
 */
public class baek1726 {
	static int[][] map;
	static Queue<Pair> q;
	//동 서 남 북
	static int[] dx = {0, 1, -1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};
	static int ans;
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		map = new int[n+1][m+1];
		q = new LinkedList<>();
		ans = Integer.MAX_VALUE;
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[][] command = new int[n+1][m+1];
		boolean[][] v = new boolean[n+1][m+1];
		
		bfs(command,v,n,m);
		
		System.out.println(ans);
		
	}
	static void bfs(int[][] command, boolean[][] v, int n, int m) {
		
	}
	
	static boolean isBound(int x, int y, int n, int m) {
		if(x<1 || y<1|| x>m|| y>n) {
			return false;
		}
		return true;
	}
}
