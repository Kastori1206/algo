package baek;

import java.util.Scanner;

public class baek11403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N+1][N+1];
		int[][] v = new int[N+1][N+1];
		for(int i =1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i= 1;i<=N;i++) {			
				dfs(map,v,i,i,N);			
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				System.out.print(v[i][j]);
				if(N!=j) {
					System.out.print(' ');
				}
			}
			System.out.println();			
		}
	}
	static void dfs(int[][] map,int[][] v, int start, int end,int N) {
		
		for(int i =1;i<=N;i++) {
			if(v[start][i] ==0 && map[end][i]==1) {
				v[start][i] =1;
				dfs(map,v,start,i,N);
			}
		}
		
	}
}
