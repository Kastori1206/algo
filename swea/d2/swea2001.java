package swea.d2;

import java.util.Scanner;

public class swea2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			
			int[][]a = new int[N][N];
			
			for(int i =0;i<N;i++) {
				for(int j=0;j<N;j++) {
					a[i][j] =sc.nextInt();
				}
			}
			
			for(int i=0;i<=N-M;i++) {
				for(int j=0;j<=N-M;j++) {
					int sum=0;
					for(int k=0;k<M;k++) {
						for(int l =0;l<M;l++) {
							sum+=a[i+k][j+l];
						}
					}
					if(max<sum) {
						max = sum;
					}
				}
			}			
			System.out.println("#"+test_case+" "+max);
			
		}
	}
}
