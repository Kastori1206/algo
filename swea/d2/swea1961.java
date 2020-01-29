package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class swea1961 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();		

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int[][] a = new int[N][N];			
			int[][] b = new int[N][N];			
			String[] result = new String[N];
			
			Arrays.fill(result, "");
			for(int i =0 ;i<N;i++) {
				for(int j =0;j<N;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			for(int k=0;k<3;k++) {
				for(int i =0;i<N;i++) {
					for(int j =0;j<N;j++) {						
						b[i][j] = a[N-1-j][i];
						result[i] += b[i][j];
					}					
					result[i] +=" ";					
				}
				for(int i=0;i<N;i++) {
					for(int j =0;j<N;j++) {
						a[i][j] = b[i][j];
					}
				}
			}	
			
			System.out.println("#"+test_case);
			for(int i =0;i<N;i++) {
				System.out.println(result[i]);
			}
		}
	}

}
