package swea.d3;

import java.util.Scanner;

public class swea5215 {
	public static void main(String args[]) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();	
		int answer = 0;

		for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] a = new int[N];
			int[] b = new int[N];

			for(int i =0;i<N;i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}	
			for(int i=0; i < 1<<N; i++) {
				int cal=0;
				int score=0;
				for(int j=0; j<N; j++) {
					if((i & 1<<j) != 0) {
						score += a[j];
						cal += b[j];
					}						
				}
				if(cal<=L) {
					if(answer<score) {
						answer = score;
					}
				}
			}

		}
	}
}