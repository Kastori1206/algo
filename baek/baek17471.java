package baek;

import java.util.Scanner;

public class baek17471 {
	static boolean[] v;
	static int n;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		n = sc.nextInt();
		int[] w = new int[n+1];
		map = new int[n+1][n+1];
		
		for(int i =1;i<=n;i++) {
			w[i] = sc.nextInt();
		}
		for(int i =1;i<=n;i++) {
			int end = sc.nextInt();
			for(int j=1;j<=end;j++ ) {
				map[i][sc.nextInt()] =1;
			}
		}
		v= new boolean[n+1];
		dfs(1);
//		for(int i =1;i<=n;i++) {
//			for(int j =1;j<=n;j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		
	}
	static void dfs(int x) {
		v[x]=true;
		System.out.println(x);
		for(int i=1;i<=4;i++) {
			if(map[x][i]==1 &&v[i]==false) {
				dfs(i);
			}
		}
	}
}