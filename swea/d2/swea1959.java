package swea.d2;

import java.util.Scanner;

public class swea1959 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int M = sc.nextInt();			
			int[] a = new int[N];
			int[] b = new int[M];
			
			int max = Integer.MIN_VALUE;
			
			//입력
			for(int i =0;i<N;i++) {
				a[i] = sc.nextInt();
			}
			for(int i =0;i<M;i++) {
				b[i] = sc.nextInt();
			}
			//최대값구하기
			//큰 수가 M
			if(N<M) {
				for(int i=0;i<M-N+1;i++) {
					
					int sum = 0;
					for(int j =0;j<N;j++) {
						sum += a[j]*b[i+j];						
					}
					if(max < sum) {
						max = sum;
					}
				}								
			}else {
				for(int i=0;i<N-M+1;i++) {
					int sum = 0;
					for(int j =0;j<M;j++) {
						sum += b[j]*a[i+j];						
					}
					if(max < sum) {
						max = sum;
					}
				}				
			}
			//출력
			System.out.println("#"+test_case+" "+max);			
		}
	}

}
