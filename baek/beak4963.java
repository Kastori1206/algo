package baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class beak4963 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	static class Pair {
		int x;
		int y;
		int cnt;	

		public Pair(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if(w == 0 && h == 0 ) {
				break;
			}
			
			int[][]map = new int[h][w];
			for(int i =0;i<h;i++) {
				for(int j =0;j<w;j++) {
					map[i][j] = sc.nextInt();
				}
			}			
		}
	}
	static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		
	}

}
