package swea.d2;

import java.util.Scanner;

public class swea1979 {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int [][]a = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j =0;j<N;j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int result =0;
			
			//가로검사
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {							
					if (isInBound(N, N, i, j) && a[i][j] == 1) {
						int cnt=1;			
						// 가로로 이동
						while (isInBound(N, N, i, j + 1) && a[i][j + 1] == 1) {
							j++;
							cnt++;
						}			
						if(cnt==K) {
							result ++;
						}
					}
				}				
			}
			//세로검사
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {								
					if (isInBound(N, N, i, j) && a[j][i] == 1) {
						int cnt=1;
						// 세로로이동
						while (isInBound(N, N, j+1, i) && a[j+1][i] == 1) {
							j++;
							cnt++;
						}			
						if(cnt==K) {
							result ++;
						}
					}
				}				
			}
			System.out.println("#"+test_case+" "+result);
		}
		
	}
	public static boolean isInBound(int r, int c, int y, int x) {
		return y >= 0 && x >= 0 && y < r && x < c;
	}

}
