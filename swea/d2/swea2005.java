package swea.d2;

import java.util.Scanner;

public class swea2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)	{
			int N = sc.nextInt();
			int[][]a = new int[N+1][N+1];
			a[0][1] = 1;
			for(int i =1;i<N+1;i++) {
				for(int j=1;j<i+1;j++) {
					a[i][j] = a[i-1][j-1]+a[i-1][j];
				}
			}
			System.out.println("#"+test_case);
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<i+1;j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}			
		}
	}

}
