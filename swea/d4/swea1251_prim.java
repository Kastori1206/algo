package swea.d4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * 1251. [S/W 문제해결 응용] 4일차 - 하나로 D4 prim
 */
public class swea1251_prim {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1 ;t<=T;t++) {
			int N = sc.nextInt(); // 정점의수
			long[][] islands = new long[N][2];

			for(int i =0;i<N;i++) {
				islands[i][0] = sc.nextLong();
			}
			for(int i =0;i<N;i++) {
				islands[i][1] = sc.nextLong();
			}
			double E = sc.nextDouble();	//환경 부담 세율
			
			long[][] adj = new long[N][N];
			for(int i =0;i<N;i++) {
				for(int j=0;j<N;j++) {				
					long d = dist(islands[i][0], islands[j][0], islands[i][1], islands[j][1]);
					adj[i][j] = d;
					adj[j][i] = d;
				}
			}
			
			boolean[] check = new boolean[N];
			long[] key = new long[N];
			Arrays.fill(key,Long.MAX_VALUE);			
			key[0] = 0;
			
			for (int i = 0; i < N - 1; i++) {
				long min = Long.MAX_VALUE;
				int index = -1;
				
				for(int j = 0; j < N; j++) {
					if( !check[j] && key[j] < min ) {
						min = key[j];
						index = j;
					}
				}
				for(int j = 0; j <N; j++) {
					if( !check[j] && adj[index][j]!=0 && key[j] > adj[index][j] ) {
						key[j] = adj[index][j];
					}
				}
				check[index] = true;
			}
			long result = 0;
			for(int i=0;i<N;i++) {
				result += key[i];
			}
			System.out.println("#" + t + " " + Math.round(result*E));
		}
	}
	
	static long dist(long x1, long x2, long y1, long y2) {
		return  (long)(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
	}
	
}
